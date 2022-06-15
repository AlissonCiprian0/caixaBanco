import java.util.ArrayList;

public class CaixaBanco {
    private Integer usuarioLogado = -1;
    private Boolean logado = false;

    private ArrayList <Usuario> usuarios = new ArrayList <Usuario>();

    public void setUsuarios() {
        usuarios.add(new Usuario(00.00, "487.891.108-54", "123", "Alisson"));
    }

    public void registra(Usuario usuario) {
        usuarios.add(usuario);
        System.out.printf("Usuário %s registrado!\n\n", usuario.getNome());
    }

    public Integer verificaLogin(String cpf) {
        if (logado) {
            logado = false;
            this.usuarioLogado = -1;
        }

        Integer i = 0;
        Boolean userExist = false;

        for (i = 0; i < usuarios.size(); i++) {
            if (cpf.equals(usuarios.get(i).getCpf())) {
                userExist = true;
                break;
            }
        }

        if (userExist)
            return i;
        return -1;
    }
    public void logar(String cpf, String senha) {
        Integer userExist = verificaLogin(cpf);

        if(userExist > -1) {
            if (senha.equals(usuarios.get(userExist).getSenha())) {
                logado = true;
                this.usuarioLogado = userExist;

                System.out.printf("Usuário logado: %s\n", usuarios.get(usuarioLogado).getNome());
            }
            else System.out.print("Senha incorreta.");
        }
        else {
            System.out.print("Usuário não encontrado.");
        }
    }

    public void depositar(Double valor) {
        usuarios.get(usuarioLogado).setSaldo(usuarios.get(usuarioLogado).getSaldo() + valor);
        System.out.println("Valor depositado!");
    }

    public void sacar(Double valor) {
        if ((usuarios.get(usuarioLogado).getSaldo() - valor) < -600.00) {
            System.out.println("\nSaque não permitido. Limite de crédito atingido.");
        }
        else {
            usuarios.get(usuarioLogado).setSaldo(usuarios.get(usuarioLogado).getSaldo() - valor);
            System.out.printf("Valor sacado!");
        }
    }

    public void mostrarSaldo() {
        System.out.printf("\nSaldo: R$ %.2f", usuarios.get(usuarioLogado).getSaldo());
    }

    public Integer getUsuarioLogado() {
        return usuarioLogado;
    }
}