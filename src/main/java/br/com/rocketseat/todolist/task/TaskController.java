package br.com.rocketseat.todolist.task;

import br.com.rocketseat.todolist.Utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);

        var currentDate = LocalDateTime.now();

        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início / data de término deve ser maior do que a data atual");
        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início deve ser menor do que a data de término");
        }

        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/")
    public ResponseEntity<?> list(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var task = this.taskRepository.findByIdUser((UUID) idUser);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> list(@RequestBody TaskModel taskModel, @PathVariable UUID id, HttpServletRequest request) {
        var task = this.taskRepository.findById(id).orElse(null);
        if (task == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa não encontrada");

        var idUser = request.getAttribute("idUser");
        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário não tem permissão para alterar essa tarefa");
        }

        Utils.copyNonNullProperties(taskModel, task);
        this.taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
