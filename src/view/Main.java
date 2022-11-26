package view;

import model.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        User u = new User();


        System.out.println("Bem vindo ao formulário: Cadastro de usuários!");

        System.out.println("-------------------------");
        System.out.println("Vamos criar o seu usuário");
        System.out.println("-------------------------");
        System.out.println("Usuário: ");
        u.setUsuario(scan.next());
        System.out.println("Primeiro nome: ");
        u.setUsuario(scan.next());
        System.out.println("Segundo nome: ");
        u.setSegundoNome(scan.next());
        System.out.println("Crie uma senha: ");
        u.setPassword(scan.next());
        System.out.println("Idade: ");
        u.setIdade(scan.next());
        System.out.println("CPF: ");
        u.setCpf(scan.nextInt());

    }

}
