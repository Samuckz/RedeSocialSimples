
import java.util.Scanner;
import java.util.ArrayList;

public class Mensagens2{

    protected String login;
    protected int id;
    protected String msg;
    protected ArrayList<Comentarios> comentarios;
    // protected ArrayList<Mensagens> comentarios;

    // REFAZER TUDO PARA APLICAR OS ATRIBUTOS DA CLASSE

    public int getId(){
        return this.id;
    }

    public String getMsg(){
        return msg;
    }

    public Mensagens2(){}

    public Mensagens2(String login, int id, String msg){
        this.login = login;
        this.id = id;
        this.msg = msg;
        ArrayList<Comentarios> comentarios = new ArrayList<Comentarios>();
        this.comentarios = comentarios;
    }


    public static void RegistrarMensagem(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);
        int done = 0;
        int id;
        String l, msg;

        Other.clear();
        System.out.println("\tREGISTRAR MENSAGEM");
        Other.line();
        System.out.println("Digite seu login: ");
        l = in.nextLine();
        Usuario user = new Usuario();
        for(int i=0; i<usuarios.size();i++){
            user = usuarios.get(i);
            if(user.login.equals(l) && user.status == 1){
                System.out.println("Digite sua mensagem: ");
                msg = in.nextLine();
                id = user.mensagens.size();

                Mensagens2 mm = new Mensagens2(l,id,msg);

                user.mensagens.add(mm);
                // Como inserir o um objeto da classe Mensagens no ArrayList???
                System.out.println("\nMensagem registrada com sucesso!\n\nDigite algo para continuar.");
                in.nextLine();

                done = 1;
                break;
            }
        }

        if (done == 0){
            System.out.println("Não foi encontrado nenhum usuário com este login.\n\nDigite algo para sair.");
            in.nextLine();
        }



    }

    public static void comentarMensagem(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);

        String login1, login2, comentario;

        int done = 0;
        int done1 = 0;
        int done2 = 0;
        int done3 =0;

        Other.clear();
        System.out.println("\tCOMENTAR MENSAGEM");
        System.out.println("Digite o login do usuário que você quer ver as mensagens: ");
        login1 = in.nextLine();

        Usuario user = new Usuario();
        for (int i=0; i<usuarios.size(); i++){
            user = usuarios.get(i);
            if(user.login.equals(login1) && user.status == 1){
                done1 = 1;
                System.out.println("Digite seu login: ");
                login2 = in.nextLine();
                Usuario user1 = new Usuario();
                for(int c=0; c<usuarios.size(); c++){
                    user1 = usuarios.get(c);
                    if(user1.login.equals(login2) && user1.status == 1){
                        done2 = 1;
                        Other.line();
                        Usuario user2 = new Usuario();
                        for(int k=0; k<user.seguidores.size(); k++){
                            user2 = user.seguidores.get(k);
                            if(user2.login.equals(login2)){
                                done3 = 1;
                                for(int y=0; y<user.mensagens.size(); y++){
                                    System.out.println("------------------------------");
                                    System.out.println("Código: " + user.mensagens.get(y).id);

                                    System.out.println("Mensagem: " + user.mensagens.get(y).msg);
                                }

                                int choice;
                                System.out.println("------------------------------");
                                System.out.println("Escolha o Código da mensagem que você quer comentar: ");
                                choice = in.nextInt();
                                // Verificador de código;


                                for(int y=0; y<user.mensagens.size(); y++){


                                    if(user.mensagens.get(y).id == choice){
                                        System.out.println("-------------------");
                                        System.out.println("Digite seu comentário: ");
                                        
                                        in.nextLine();
                                        comentario = in.nextLine();
                                        in.nextLine(); // limpar buffer

                                        int id2 = user.mensagens.get(y).comentarios.size();

                                        Comentarios cc = new Comentarios(login2, id2, comentario);

                                        user.mensagens.get(y).comentarios.add(cc);


                                        Other.line();
                                        System.out.println("Comentário feito com sucesso!\n\nDigite algo para continuar.");
                                        in.nextLine();
                                        done = 1;
                                        break;

                                    }
                                }
                                if(done == 0){
                                    System.out.println("Favor digite um Código válido.");
                                }

                            }

                        }

                        if(done3 == 0){
                            System.out.println("Você não segue este usuário\n\nDigite algo para continuar.");
                            in.nextLine();
                            break;


                        }

                    }

                }

                if(done2 == 0){
                    System.out.println("Este usuário não existe!\n\nDigite algo para continuar.");
                    in.nextLine();
                    break;
                }
            }


        }

        if(done1 == 0){

            System.out.println("Este usuário não existe!\n\nDigite algo para continuar.");
            in.nextLine();
        }

    }

    public static void verMensagens(ArrayList<Usuario> usuarios){
        Scanner in = new Scanner(System.in);
        String login;
        int done, id;
        done = 0;
        int done1=0;

        Other.clear();
        System.out.println("\tVER MENSAGENS");
        Other.line();
        System.out.println("Digite seu login: ");
        login = in.nextLine();

        for(Usuario user : usuarios){
            if(login.equals( user.login) && user.status == 1){
              Other.line();
                System.out.println("Mensagens de " + login);
                System.out.println("-------------------");
                for(Mensagens2 mensagem : user.mensagens) {
                    System.out.println("Código: " + mensagem.id);
                    System.out.println("Mensagem: " + mensagem.msg);
                    System.out.println("-------------------");
                }
            

                System.out.println("\nEscolha o código da mensagem que você quer ver os comentários: ");
                id = in.nextInt();


                for(int z=0; z<user.mensagens.size(); z++){
                  if(user.mensagens.get(z).id == id){
                    Other.line();
                    
                    for(int q=0; q<user.mensagens.get(z).comentarios.size(); q++){
                      System.out.println("Código: " + user.mensagens.get(z).comentarios.get(q).id);
                      System.out.println("Usuário: " + user.mensagens.get(z).comentarios.get(q).login);
                      System.out.println("Comentario: " + user.mensagens.get(z).comentarios.get(q).comentario);
                      System.out.println("-------------------");

                    }

                    System.out.println("Digite algo para continuar");
                    in.nextLine();
                    in.nextLine();
                  }

                }

            }

        }
    }
}