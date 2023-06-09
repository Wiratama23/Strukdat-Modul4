import java.util.HashMap;
import java.util.Scanner;

public class Login extends DataPraktikan{
    private HashMap<String, String> tabelSesiLogin;

    public Login() {
        tabelSesiLogin = new HashMap<>();

        tabelSesiLogin.put("romi@umm.ac.id", "romi");
    }

    public void login() {
        Scanner input = new Scanner(System.in);

        System.out.println("======Login======");
        System.out.print("Masukkan email: ");
        String email = input.nextLine();

        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            if (email.endsWith("@umm.ac.id")) {
                menu();
                System.out.println("!!! Anda telah keluar dari akun !!!");
            } else {
                System.out.println("!!! Gagal Login: Email harus menggunakan domain @umm.ac.id !!!");
            }
        } else {
            System.out.println("!!! Gagal Login: Email atau password salah !!!");
        }
    }



    public static void main(String[] args) {
        Login tes = new Login();

        tes.login();
    }

}
