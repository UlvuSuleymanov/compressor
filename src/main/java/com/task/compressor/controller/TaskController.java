package com.task.compressor.controller;

import com.task.compressor.model.AddedTaskResponse;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;
import com.task.compressor.model.ZipRequestModel;
import com.task.compressor.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

@RestController
public class TaskController {

    @Autowired
    private TaskService  taskService;


    @PostMapping("/zip")
    public AddedTaskResponse zip (@RequestBody final ZipRequestModel zipRequestModel){





       Task task = taskService.zipFile(zipRequestModel.getPath());


       return new AddedTaskResponse(task.getId());
    }

    @GetMapping("/status")
    ResponseEntity getStatus(@RequestParam("id") Integer id){
        ReadyTaskResponse readyTaskResponse = taskService.getStatus(id);
        return  ResponseEntity.ok(readyTaskResponse);
    }

}
