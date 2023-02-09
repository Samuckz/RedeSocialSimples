import java.util.Scanner;
import java.util.ArrayList;

public class Usuario{
  protected String nome;
  private String email;
  private DataHora nascimento;
  protected String login;
  private Scanner in;
  //protected ArrayList<String> seguidores;
  protected ArrayList<Usuario> seguidores;
  protected int num_seguidores = 0;
  protected ArrayList<Usuario> seguidos;
  protected int num_seguidos = 0;
  //protected ArrayList<Mensagens> mensagens;
  protected ArrayList<Mensagens2> mensagens;
  protected int status;

  public Usuario(){}
  
  public Usuario(Scanner in){
    this.in = in;
    this.CadastrarUsuario();
  }

  public String getLogin(){
    return login;
  }

  public String getNome(){
    return nome;
  }
  
  public void CadastrarUsuario(){
    int dia, mes, ano;
    
    Other.clear();
    System.out.println("\tCADASTRAR USUÁRIO");
    Other.line();
    System.out.print("Nome: ");
    in.nextLine(); // Limpando buffer
    this.nome = this.in.nextLine();
    
    System.out.print("Email: ");
    //in.nextLine(); // Limpando buffer
    this.email = this.in.nextLine();
    System.out.println("DIA DE NASCIMENTO");
    System.out.print("Dia: ");
    dia = this.in.nextInt();
    System.out.print("Mês: ");
    mes = this.in.nextInt();
    System.out.print("Ano: ");
    ano = this.in.nextInt();
    // VERIFICADOR DE IDADE?

    ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
    this.seguidores = seguidores;

    ArrayList<Usuario> seguidos = new ArrayList<Usuario>();
    this.seguidos = seguidos;

    /*ArrayList<Mensagens> mensagens = new ArrayList<Mensagens>();
    this.mensagens = mensagens;*/
    
    ArrayList<Mensagens2> mensagens = new ArrayList<Mensagens2>();
    this.mensagens = mensagens;
    
    this.nascimento = new DataHora(dia, mes, ano);

    System.out.print("Login: ");
    in.nextLine(); // Limpando buffer
    this.login = this.in.nextLine();

    Other.line();
    System.out.println("Usuário cadastrado com sucesso!\n\nDigite algo para continuar");
    this.status = 1;
    in.nextLine();
    
  }

  public static void ExcluirUsuario(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    String x;
    int done = 0;
    Other.clear();
    System.out.println("\tEXCLUIR USUÁRIO");
    Other.line();
    System.out.println("Digite o login do usuário que você deseja excluir: ");
    x = in.nextLine();
    //in.nextLine(); // limpar buffer

    Usuario u = new Usuario();
    for(int i=0; i<usuarios.size(); i++){
      u = usuarios.get(i);
      if(u.login.equals(x)){
        u.status = 0;
        done = 1;
        System.out.println("Usuário excluído com sucesso!\n\nDigite algo para continuar.");
        in.nextLine();
        break;
      }
    }

    if (done == 0){
      System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para continuar.");
      in.nextLine();
    }
  }

  public static void ListarUsuarios(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    Usuario u = new Usuario();
    Other.clear();
    System.out.println("\tLISTAR USUÁRIOS");
    
    for (int i = 0; i<usuarios.size(); i++){
      u = usuarios.get(i);
      if (u.status == 1){
        Other.line();
        System.out.println("Usuário " + (i+1));
        System.out.println("Login: " + u.login);
        System.out.println("Nome: " + u.nome);
      }
    }
    Other.line();
    System.out.println("\nDigite algo para continuar.");
    in.nextLine();

  }

  public static void PesquisarUsuario(ArrayList<Usuario> usuarios){
    String login;
    int done = 0;
    Scanner in = new Scanner(System.in);
    
    Other.clear();
    System.out.println("\tPESQUISAR USUÁRIO");
    Other.line();
    System.out.println("Digite o login do usuário que você deseja pesquisar: ");
    login = in.next();
    
    Usuario u = new Usuario();
    for(int i=0; i<usuarios.size(); i++){
      u = usuarios.get(i);
      if(u.login.equals(login) && u.status == 1){
        done = 1;
        System.out.println("----------------");
        System.out.println("Login: " + u.login);
        System.out.println("Nome: " + u.nome);
        Other.line();
        System.out.println("\nDigite algo para continuar.");
        in.nextLine();
        in.nextLine(); // limpar buffer
        break;
      }        
    }

    if(done == 0){
      System.out.println("Não foi encontrado nenhum usuário com este login.\nDigite algo para continuar.");
      in.nextLine();
      in.nextLine(); // limpar buffer
    }


      
  } // FIM DO PESQUISAR USUARIO

  public static void AlterarUsuario(ArrayList<Usuario> usuarios){
    Scanner in = new Scanner(System.in);
    String login;
    int done = 0;
    Other.clear();

    System.out.println("\tALTERAR USUÁRIO");
    Other.line();
    System.out.println("Digite o login do usuário que você quer alterar: ");
    login = in.next();
    

    Usuario u = new Usuario();
    for(int i=0; i<usuarios.size(); i++){
      u = usuarios.get(i);
      if(u.login.equals(login) && u.status == 1){
        done = 1;
        u.CadastrarUsuario();

        System.out.println("Usuário cadastrado com sucesso!\n\nDigite algo para continuar");
        in.next();
        break;
      }
    }

    if (done == 0){
      System.out.println("Não foi encontrado nenhum usuário com este login.\nDigite algo para continuar.");
      in.nextLine();
      in.nextLine();
      
    }

  }// FIM DO ALTERAR USUARIO

  public int getUsuario(Scanner in, ArrayList<Usuario> usuarios) {
    
    String l;

    l = in.nextLine();
    Usuario user = new Usuario();
    for(int i=0; i<usuarios.size();i++){
      user = usuarios.get(i);
      if (user.login.equals(l) && user.status == 1){
        return i;
      }
    }

    return -1;  
    
  }

  
}


