package DIO_Jdbc.DIO_Jdbc;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.function.Consumer;

import dao.AlunoDAO;
import entidade.Aluno;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
    	
       AlunoDAO alunoDAO = new AlunoDAO();
       
//       //===================1 - Consulta ===============================
//       List<Aluno> alunos = alunoDAO.list();
//       
//       alunos.stream().forEach(System.out::println);
//       
       //==================================================================
       
       
     //======================1.1 - Consulta com Filtro ====================
//       Aluno alunoParaConsulta = alunoDAO.getById(1);
//       
//       System.out.println(alunoParaConsulta);
     //====================================================================       
      
     //================== 2 - Inserção ====================================
//       Aluno alunoParaInsercao = new Aluno();
//       
//       alunoParaInsercao.setNome("Mauricio");
//       alunoParaInsercao.setIdade(33);
//       alunoParaInsercao.setEstado("PE");
//       
//       alunoDAO.create(alunoParaInsercao);
      //===================================================================
       
       
      //================ 3 - Delete =======================================
       
//       alunoDAO.list().stream().forEach(System.out::println);
       
//       alunoDAO.delete(5);
       
//       alunoDAO.list().stream().forEach(System.out::println);
      //====================================================================
       
       
      //================== 4 - Atualiar ====================================
       alunoDAO.list().stream().forEach(System.out::println);
       
       Aluno alunoParaAtualizar = alunoDAO.getById(3);
       		 alunoParaAtualizar.setNome("Lucas");
       		 alunoParaAtualizar.setIdade(27);
       		 alunoParaAtualizar.setEstado("PE");
       		
       		alunoDAO.update(alunoParaAtualizar);
       alunoDAO.list().stream().forEach(System.out::println);
       //====================================================================
       
    }
    
}
