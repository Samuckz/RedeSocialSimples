import java.util.Scanner;
import java.util.ArrayList;

public class Seguidores{
  public static void Seguir(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    String a, b;
    int done1 = 0;
    int done2 = 0;
    
    Other.clear();
    System.out.println("\tSEGUIR");
    Other.line();
    System.out.println("Digite o login do usuário que irá seguir outro usuário: ");
    a = in.nextLine();
    //in.nextLine(); // limpar buffer

    Usuario user = new Usuario();
    Usuario user1 = new Usuario();
    for (int i=0; i<usuarios.size(); i++){
      user = usuarios.get(i);
      if(user.login.equals(a) && user.status == 1){
        done1 = 1;
        System.out.println("Digite o login do usuário que será seguido:");
        b = in.nextLine();
        //Usuario user1 = new Usuario();
        for(int c=0; c<usuarios.size();c++){
          user1 = usuarios.get(c);
          if(user1.login.equals(b) && user1.status == 1){
            
            // ERRO AQUI
            // Null pointer exception
            done2 = 1;
            user1.seguidores.add(user);
            user1.num_seguidores += 1;
            user.seguidos.add(user1);
            user.num_seguidos += 1;

            System.out.println("Agora, " + a + " está seguindo " + b + ".\n\nDigite algo para continuar.");
            in.nextLine();
            break;
            
          }
        }

        
      }

    }
    if (done1 == 0){
      System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para continuar: ");
      in.nextLine();
    }
  }// FIM DA FUNÇÃO SEGUIR




  public static void cancelarSeguir(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    String a, b;
    int done1 = 0; 
    int done2 = 0;
    
    Other.clear();
    System.out.println("\tDEIXAR DE SEGUIR");
    Other.line();
    System.out.println("Digite seu login: ");
    a = in.nextLine();
    
    
    Usuario user = new Usuario();
    for (int i=0; i<usuarios.size(); i++){
      user = usuarios.get(i);
      if(user.login.equals(a) && user.status == 1){
        done1 = 1;
        
        System.out.println("Digite o login do usuário que você deixará de seguir:");
        b = in.nextLine();
        
        Usuario user1 = new Usuario();
        for(int c=0; c<usuarios.size();c++){
          user1 = usuarios.get(c);
          if(user1.login.equals(b) && user1.status == 1){
            done2 = 1;
            user.seguidores.remove(user1);
            user.num_seguidores -= 1;
            user1.seguidos.remove(user);
            user.num_seguidos -= 1;

            // ERRO AQUI, para de uma vez

            System.out.println(a + " deixou de seguir " + b + ".\n\nDigite algo para continuar.");
            in.nextLine();
            break;
          }
        }
        if (done2 == 0){
          System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para sair.");
          in.nextLine();
          break;
          }
      }

      
    }
    if (done1 == 0) {
      System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para continuar: ");
      in.nextLine();
    }
    

    
    


  }// FIM DA FUNÇÃO CANCELAR_SEGUIR
}