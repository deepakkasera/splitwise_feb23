package com.scaler.splitwise_feb23;

import com.scaler.splitwise_feb23.controllers.GroupController;
import com.scaler.splitwise_feb23.dtos.SettleUpGroupRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseFeb23Application implements CommandLineRunner {

    @Autowired
    private GroupController groupController;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseFeb23Application.class, args);
    }

    // varargs
    // run("a")
    // run("a", "b")
    @Override
    public void run(String... args) throws Exception {
//        CommandLineRegistry registry = new CommandLineRegistry();
//        registry.register(new RegisterUserCommand());
//        registry.register(new SettleUpGroupCommand());
//
//        while (true) {
//            String input = // input from command line
//
//            try {
//                registry.execute(input);
//            } catch (NoValidCommandException e) {
//                System.out.println("Command not valid");
//            }
//        }
        SettleUpGroupRequestDTO requestDTO = new SettleUpGroupRequestDTO();
        requestDTO.setGroupId(1L);
        groupController.settleUp(requestDTO);
    }
}
