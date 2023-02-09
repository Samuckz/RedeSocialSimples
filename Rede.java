import java.util.Scanner;
import java.util.ArrayList;

public class Rede{

  public static void Seguidores(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    String a;
    int done = 0;

    Other.clear();
    System.out.println("\tSEGUIDORES");
    Other.line();
    System.out.println("Digite seu login para ver seus seguidores:");
    a = in.nextLine();

    
    Usuario user = new Usuario();
    for(int i=0; i<usuarios.size();i++){
      user = usuarios.get(i);
      if(user.login.equals(a) && user.status == 1){
        done =1;
        Other.line();
        System.out.println("Seguidores de " + a);
        for(int c=0; c<user.num_seguidores; c++){

          System.out.println("------------------");
          
          System.out.println("Login: "+ user.seguidores.get(c).login);
          System.out.println("Nome: "+ user.seguidores.get(c).nome); 
        }
      
      System.out.println("\nDigite algo para continuar.");
      in.nextLine();
      }

    }


    if(done == 0){
      System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para sair.");
      in.nextLine();
      in.nextLine();
    }



  }


  public static void Seguidos(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    String a;
    int done = 0;

    Other.clear();
    System.out.println("\tSEGUIDOS");
    Other.line();
    System.out.println("Digite seu login: ");
    a = in.nextLine();

    Usuario user = new Usuario();
    for(int i=0; i<usuarios.size();i++){
      user = usuarios.get(i);
      if(user.login.equals(a) && user.status == 1){
        done =1;
        for(int c=0; c<user.num_seguidos; c++){

          //ERRO AQUI;
          // 
          Other.line();
          System.out.println("Login: "+ user.seguidos.get(i).login);
          System.out.println("Nome: "+ user.seguidos.get(i).nome); 
        }
      
      System.out.println("\nDigite algo para continuar.");
      in.nextLine();
      }

    }

    if(done == 0){
      System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para sair.");
      in.nextLine();
      in.nextLine();
    }
  }


  public static void MaisInfluente(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    Other.clear();
    System.out.println("\tMAIS INFLUENTE");
    Other.line();
    int best = 0;
    int pos = 0;

    Usuario user = new Usuario();
    for(int i=0; i<usuarios.size(); i++){
      user = usuarios.get(i);
      if(user.num_seguidores > best && user.status == 1){
        best = user.num_seguidores;
        pos = i;
      }
    }

    
    System.out.println("Login: " + usuarios.get(pos).login);
    System.out.println("Nome: " + usuarios.get(pos).nome);
    System.out.println("Seguidores: " + usuarios.get(pos).num_seguidores);

    Other.line();
    System.out.println("\tDigite algo para continuar.");
    in.nextLine();

  }



  
}