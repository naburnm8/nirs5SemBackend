package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Message;

@RestController
@RequestMapping("/api/connection")
public class UtilityController {
    @GetMapping
    public ResponseEntity<Message> getConnection() {
        return ResponseEntity.ok(new Message("borovik"));
    }
    @GetMapping("/info")
    public ResponseEntity<Message> getInfo() {
        return ResponseEntity.ok(new Message("Да я зашел, смотрел [REDACTED] на динамиках." +
                " Она спросила, че это там у тебя. Я говорю [REDACTED]. Она спросила," +
                " за [REDACTED] он или нет. Я говорю против. Она говорит, что такое смотреть не надо." +
                " Я ответил, что он еврей, а еврей глупостей говорит не будет. Тут она начала разгонять," +
                " что мою сестру за тебя надо выдавать замуж." +
                " Я сказал, что не желаю тебе такой участи, а потом она выдала, что Катя будет дурой, если выйдет за меня, потому что я ирод, этакая гангрена и вредина"));
    }
}
