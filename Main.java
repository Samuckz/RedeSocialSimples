import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Main{
  public static void main(String[] args){
    int c1 = 0;
    int c2 = 0; // Variáveis de escolhas
    
    Scanner in = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Usuario u = new Usuario();
    
    
    while (c1 != 5){
      Other.clear();
    System.out.println("\tSNAPFET");
    Other.line();
    System.out.println("{1} - Usuário\n{2} - Seguidores\n{3} - Mensagens\n{4} - Rede\n{5} - Sair");
    Other.line();
    System.out.print("O que deseja analisar: ");
    c1 = in.nextInt();
    while(c1 < 1 || c1 > 5){
      System.out.println("Por favor insire um valor entre 1 e 5: ");
      c1 = in.nextInt();
    }

    switch(c1){
      case 1:
        while (c2 != 6){
          Other.clear();
          System.out.println("\tUSUÁRIOS");
          Other.line();
          System.out.println("{1} - Cadastrar usuário\n{2} - Excluir usuário\n{3} - Listar usuários\n{4} - Pesquisar usuário\n{5} - Alterar usuário\n{6} - Sair");
          Other.line();
          System.out.print("O que deseja analisar: ");
          c2 = in.nextInt();
          while(c2 < 1 || c2 > 6){
            System.out.println("Por favor insire um valor entre 1 e 6: ");
            c2 = in.nextInt();
          }
          
          switch(c2){
            case 1:
              u = new Usuario(in);
              usuarios.add(u);
              break;
            
            case 2:
              Usuario.ExcluirUsuario(usuarios);
              break;

            case 3:
              Usuario.ListarUsuarios(usuarios);
              break;
            
            case 4:
              Usuario.PesquisarUsuario(usuarios);
              break;

            case 5:
              Usuario.AlterarUsuario(usuarios);
              break;
          }
        }
        
        break;
        // FIM DO CASE 1

        case 2:
        while (c2 != 3){
          Other.clear();
          System.out.println("\tSEGUIDORES");
          Other.line();
          System.out.println("{1} - Seguir\n{2} - Deixar de seguir\n{3} - Sair");
          Other.line();
          System.out.print("O que deseja analisar: ");
          c2 = in.nextInt();
          while(c2 < 1 || c2 > 3){
            System.out.println("Por favor insire um valor entre 1 e 3: ");
            c2 = in.nextInt();
          }
          
          switch(c2){
            case 1:
              Seguidores.Seguir(usuarios);
              break;
            
            case 2:
              Seguidores.cancelarSeguir(usuarios);
              break;

          }

        }
        
        break;
        // FIM DO CASE 2

        case 3:
        while (c2 != 4){
          Other.clear();
          System.out.println("\tMENSAGENS");
          Other.line();
          System.out.println("{1} - Registar mensagem\n{2} - Comentar mensagem\n{3} - Ver mensagens\n{4} - Sair");
          Other.line();
          System.out.print("O que deseja analisar: ");
          c2 = in.nextInt();
          while(c2 < 1 || c2 > 4){
            System.out.println("Por favor insire um valor entre 1 e 4: ");
            c2 = in.nextInt();
          }
          
          switch(c2){
            case 1:
              Mensagens2.RegistrarMensagem(usuarios);
              break;
            
            case 2:
              Mensagens2.comentarMensagem(usuarios);
              break;

            case 3:
              Mensagens2.verMensagens(usuarios);
              break;

          }
        
        }
        break;
        // FIM DO CASE 3

        case 4:
        while (c2 != 5){
          Other.clear();
          System.out.println("\tREDE");
          Other.line();
          System.out.println("{1} - Seguidores\n{2} - Seguindo\n{3} - Mais influência\n{4} - Trending Topics\n{5} - Sair");
          Other.line();
          System.out.print("O que deseja analisar: ");
          c2 = in.nextInt();
          while(c2 < 1 || c2 > 5){
            System.out.println("Por favor insire um valor entre 1 e 5: ");
            c2 = in.nextInt();
          }
          
          switch(c2){
            case 1:
              Rede.Seguidores(usuarios);
              break;
            
            case 2:
              Rede.Seguidos(usuarios);
              break;
            
            case 3:
              Rede.MaisInfluente(usuarios);
              break;

            case 4:

              break;


          }
          
        }
        break;
      }
    }

    Other.clear();
    System.out.println("---------------------------------");
    System.out.println("PROGRAMA FINALIZADO COM SUCESSO!");
    System.out.println("---------------------------------");
    
  }
}