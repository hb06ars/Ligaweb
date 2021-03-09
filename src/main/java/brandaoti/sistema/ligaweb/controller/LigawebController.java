package brandaoti.sistema.ligaweb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import brandaoti.sistema.ligaweb.dao.ClassificacaoDao;
import brandaoti.sistema.ligaweb.dao.PerfilDao;
import brandaoti.sistema.ligaweb.dao.ResultadoDao;
import brandaoti.sistema.ligaweb.dao.UsuarioDao;
import brandaoti.sistema.ligaweb.model.Classificacao;
import brandaoti.sistema.ligaweb.model.Perfil;
import brandaoti.sistema.ligaweb.model.Resultado;
import brandaoti.sistema.ligaweb.model.Usuario;


@Controller
public class LigawebController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PerfilDao perfilDao;
	@Autowired
	private ResultadoDao resultadoDao;
	@Autowired
	private ClassificacaoDao classificacaoDao;
	
	public static Usuario usuarioSessao;
	public static String atualizarPagina = null;
	public static String mensagem = "";
	public static String tituloMensagem = "";
	public static String tipoMensagem = "";
	public static String periodoAtual = "";
	public static String hoje = "";
	public static String itemMenuSelecionado = "home";
	
	public String verificaLink(String link) {
		String direcao = "deslogar";
		if(usuarioSessao != null) {
			direcao = link;
			itemMenuSelecionado = link;
		} else {
			direcao = "deslogar";
			atualizarPagina = null;
			itemMenuSelecionado = "home";
		}
		return direcao;
	}
	
	public void registraMsg(String titulo, String msg, String tipo) {
		tituloMensagem = titulo;
		mensagem = msg;
		tipoMensagem = tipo;
	}
	
	public ModelAndView enviaMsg(ModelAndView modelAndView) {
		modelAndView.addObject("mensagem", mensagem);
		modelAndView.addObject("tituloMensagem", tituloMensagem);
		modelAndView.addObject("tipoMensagem", tipoMensagem);
		mensagem = null;
		tituloMensagem = null;
		tipoMensagem = null;
		return modelAndView;
	}
	
	
	
	public String diaDaSemana() {
		Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String nome = "";
		int dia = c.get(c.DAY_OF_WEEK);
		switch(dia){
		case Calendar.SUNDAY: nome = "Domingo";
			break;
		case Calendar.MONDAY: nome = "Segunda";
			break;
		case Calendar.TUESDAY: nome = "Terça";
			break;
		case Calendar.WEDNESDAY: nome = "Quarta";
			break;
		case Calendar.THURSDAY: nome = "Quinta";
			break;
		case Calendar.FRIDAY: nome = "Sexta";
			break;
		case Calendar.SATURDAY: nome = "Sábado";
			break;
		}
		return nome;
	}
	
	public void hoje() {
		Calendar c = Calendar.getInstance();
		int ano = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH);
		m++;
		String mes = ""+m;
		if(m < 10){
		    mes = "0"+m;
		}
		int d = c.get(Calendar.DAY_OF_MONTH);
        String dia=""+d;
		if(d < 10){
		    dia = "0"+d;
		}
		hoje = ano+"-"+mes+"-"+dia;
	}
	
	@GetMapping({"/","/index"}) 
		public ModelAndView index(Model model) { 
		ModelAndView modelAndView = new ModelAndView("index");
		List<Usuario> usuarios = usuarioDao.findAll();
		List<Perfil> perfis = perfilDao.findAll();
		hoje();
		if(perfis.size() == 0) {
			Perfil p = new Perfil();
			p.setAtivo(true);
			p.setNome("Admnistrador");
			p.setCodigo("1");
			p.setAdmin(true);
			p.setJogador(true);
			perfilDao.save(p);
			
			p = new Perfil();
			p.setAtivo(true);
			p.setNome("Jogador");
			p.setCodigo("2");
			p.setAdmin(false);
			p.setJogador(true);
			perfilDao.save(p);

		}
		if(usuarios.size() == 0) {
			Usuario u = new Usuario();
			u.setAtivo(true);
			u.setPrimeiroAcesso(true);
			u.setTelefone("(11)98937-6271");
			u.setPerfil(perfilDao.buscarAdm().get(0));
			u.setLogin("hb06ars");
			u.setNome("Henrique Brandão");
			u.setSenha("kzdut");
			u.setAcesso("");
			usuarioDao.save(u);
			
			Classificacao c = new Classificacao();
			c.setAtivo(true);
			c.setJogador(u);
			classificacaoDao.save(c);
		}
		
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		return modelAndView; 
	}
	
	@GetMapping(value = "/deslogar")
	public ModelAndView deslogar(Model model) {  
		String link = "/deslogar";
		usuarioSessao = null;
		ModelAndView modelAndView = new ModelAndView(link); 
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/adm/deletando/{tabela}/{id}", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}) // Pagina de Alteração de Perfil
	public ModelAndView deletando(Model model,@PathVariable("tabela") String tabela, @PathVariable("id") Integer id) { //Função e alguns valores que recebe...
		String link = verificaLink("/deslogar");
		if(usuarioSessao.getPerfil().getAdmin()) {
			model.addAttribute("usuarioSessao", usuarioSessao);
			link = "/pages/"+tabela;
			if(tabela.equals("token")) {
				atualizarPagina = "/token";
				Usuario objeto = usuarioDao.findById(id).get();
				if(objeto != null)
					usuarioDao.deleteById(id);
				usuarioDao.flush();
				List<Usuario> tokens = usuarioDao.buscaTokens();
				model.addAttribute("atualizarPagina", atualizarPagina);
				model.addAttribute("tokens", tokens);
				model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
				registraMsg("Token", "Deletado com sucesso.", "erro");
			}
			if(tabela.equals("meusJogos")) {
				atualizarPagina = "/meusJogos";
				Resultado objeto = resultadoDao.findById(id).get();
				if(objeto != null)
					resultadoDao.deleteById(id);
				resultadoDao.flush();
				List<Resultado> resultados = resultadoDao.todosResultados();
				model.addAttribute("atualizarPagina", atualizarPagina);
				model.addAttribute("meusJogos", resultados);
				model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
				registraMsg("Meus Jogos", "Jogo cancelado com sucesso.", "erro");
			}
			if(tabela.equals("resultados")) {
				atualizarPagina = "/resultados";
				Resultado objeto = resultadoDao.findById(id).get();
				if(objeto != null)
					resultadoDao.deleteById(id);
				resultadoDao.flush();
				List<Resultado> resultados = resultadoDao.todosResultados();
				model.addAttribute("atualizarPagina", atualizarPagina);
				model.addAttribute("resultados", resultados);
				model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
				registraMsg("Resultados", "Jogo deletado com sucesso.", "erro");
			}
			if(tabela.equals("classificacao")) {
				atualizarPagina = "/classificacao";
				List<Resultado> objeto = resultadoDao.findAll();
				if(objeto != null) {
					for(Resultado r : objeto) {
						resultadoDao.deleteById(r.getId());
						resultadoDao.flush();
					}
				}
				List<Classificacao> classificacaoLimpar = classificacaoDao.findAll();
				if(classificacaoLimpar != null) {
					for(Classificacao c : classificacaoLimpar) {
						c.setPontos(0);
						c.setVitorias(0);
						c.setEmpates(0);
						c.setDerrotas(0);
						c.setGp(0);
						c.setGc(0);
						c.setSg(0);
						c.setJogos(0);
						classificacaoDao.save(c);
					}
				}
				List<Classificacao> classificacao = classificacaoDao.todaClassificacao();
				model.addAttribute("classificacao", classificacao);
				model.addAttribute("atualizarPagina", atualizarPagina);
				model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
				registraMsg("Jogos", "Jogos deletados com sucesso.", "erro");
			}
			
		}
		ModelAndView modelAndView = new ModelAndView(link);
		enviaMsg(modelAndView);
		return modelAndView; 
	}

	
	
	@RequestMapping(value = "/criar", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView criar(Model model, Usuario usuario, String codigoAcesso, String confirmaSenha) {  
		String link = "/criar";
		String erro="";
		String msg="";
		if(codigoAcesso != null && confirmaSenha != null) {
			if(!codigoAcesso.equals("") && !confirmaSenha.equals("")) {
				if(confirmaSenha.equals(usuario.getSenha())) {
					if(usuario.getLogin() != null) {
						if(!usuario.getLogin().replace(" ", "").equals("") && !usuario.getLogin().replace(" ", "").equals(" ")) {
							List<Usuario> u = usuarioDao.buscaLogin(usuario.getLogin());
							if(u.size() == 0) {
								Usuario user = usuarioDao.buscaAcesso(codigoAcesso);
								if(user != null) {
									user.setAcesso("");
									user.setAtivo(true);
									user.setLogin(usuario.getLogin().replace(" ", ""));
									user.setNome(usuario.getNome());
									user.setPerfil(perfilDao.buscarJogador().get(0));
									user.setPrimeiroAcesso(true);
									user.setSenha(usuario.getSenha());
									user.setTelefone(usuario.getTelefone());
									usuarioDao.save(user);
									
									Classificacao c = new Classificacao();
									c.setAtivo(true);
									c.setJogador(user);
									classificacaoDao.save(c);
									
									msg = "Usuário "+usuario.getLogin()+" cadastrado com sucesso!";
								} else {
									erro = "Código de acesso inválido!";
									model.addAttribute("erro", erro);
								}
								model.addAttribute("msg", msg);
							} else {
								erro = "Login já existe.";
								model.addAttribute("erro", erro);
							}
						} else {
							erro = "Login inválido.";
							model.addAttribute("erro", erro);
						}
					}
				} else {
					erro = "Senha não confere com a confirmação";
					model.addAttribute("erro", erro);
				}
			}
		}	
		ModelAndView modelAndView = new ModelAndView(link); 
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/home", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView logar(Model model, @RequestParam(value = "usuarioVal", defaultValue = "", required=false ) String variavelUsuario, @RequestParam(value = "senhaVal", defaultValue = "", required=false ) String variavelSenha) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		Usuario usu = usuarioDao.fazerLogin(variavelUsuario, variavelSenha);
		if(usu != null)
			usuarioSessao = usu;
		if(usu != null || usuarioSessao != null) {
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/home");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/senha", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView senha(Model model, String confirmaSenha, String senhaAtual, String novaSenha, Usuario usuario) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		if(usuarioSessao != null) {
			if(confirmaSenha != null) {
				if(!confirmaSenha.equals("")) {
					if(confirmaSenha.equals(novaSenha)) {
						if(usuarioSessao.getSenha().equals(senhaAtual)) {
							Usuario u = usuarioDao.findById(usuarioSessao.getId()).get();
							u.setSenha(novaSenha);
							usuarioDao.save(u);
							registraMsg("Senha", "Senha alterada com sucesso!.", "info");
						} else {
							registraMsg("Senha", "Senha inválida.", "erro");
						}
					} else {
						registraMsg("Senha", "Confirmação de senha não confere.", "erro");
					}
				}
			}
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/senha");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		enviaMsg(modelAndView);
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/disponibilidade", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView disponibilidade(Model model, String mensagem, String data, Boolean disponivel) throws ParseException { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		if(usuarioSessao != null) {
			if(data != null || mensagem != null) {
				if(data != null) {
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
					Date dia = formato.parse(data);
					usuarioSessao.setDataDisponibilidade(dia);
				}
				if(disponivel != null) {
					if(disponivel) {
						usuarioSessao.setDisponivel(true);
					} else {
						usuarioSessao.setDisponivel(false);
					}
				}
				if(mensagem != null)
					usuarioSessao.setMsg(mensagem);
				usuarioDao.save(usuarioSessao);
				model.addAttribute("usuarioSessao", usuarioSessao);
			}
		}
		String link = verificaLink("pages/disponibilidade");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		enviaMsg(modelAndView);
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/token", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView token(Model model, Integer criarToken, Usuario usuario) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		if(usuarioSessao != null) {
			if(criarToken != null) {
				if(criarToken == 1) {
					Usuario u = new Usuario();
					u.setAtivo(false);
					u.setAcesso(usuario.getAcesso());
					u.setNome(usuario.getNome());
					u.setLogin(usuario.getLogin());
					usuarioDao.save(u);
				}
			}
			List<Usuario> tokens = usuarioDao.buscaTokens();
			model.addAttribute("tokens", tokens);
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/token");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/resultados", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView resultados(Model model) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		if(usuarioSessao != null) {
			List<Resultado> resultados = resultadoDao.todosResultados();
			model.addAttribute("resultados", resultados);
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/resultados");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		return modelAndView; 
	}
	
	@RequestMapping(value = "/classificacao", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView classificacao(Model model) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		if(usuarioSessao != null) {
			List<Classificacao> classificacao = classificacaoDao.todaClassificacao();
			model.addAttribute("classificacao", classificacao);
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/classificacao");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		return modelAndView; 
	}
	
	
	@RequestMapping(value = "/adversario", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView adversario(Model model, String id_adv, String data, String hora) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		if(usuarioSessao != null) {
			if(id_adv != null && data != null && hora != null) {
				String str = data+" "+hora; 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
				LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
				Resultado r = new Resultado();
				r.setJogador1(usuarioSessao);
				r.setJogador2(usuarioDao.findById(Integer.parseInt(id_adv)).get());
				if(r.getJogador2() != null) {
					if(r.getJogador2().getId() != usuarioSessao.getId()) {
						//Verifique antes se tem 2 jogos ja jogados entre os dois jogadores...
						List<Resultado> limite = resultadoDao.limiteDeJogos(usuarioSessao.getId(), r.getJogador2().getId());
						System.out.println("Limite: " + limite);
						if(limite.size() < 2) {
							//Validado e marcando o jogo
							r.setData(dateTime);
							resultadoDao.save(r);
							registraMsg(usuarioSessao.getNome(), "Jogo marcado com sucesso contra "+r.getJogador2().getNome()+"!", "info");
						} else {
							registraMsg(usuarioSessao.getNome(), "Você pode jogar até dois jogos (Ida e Volta) contra o "+r.getJogador2().getNome()+" neste campeonato. Consulte o regulamento!", "erro");
						}
						
					} else {
						registraMsg(usuarioSessao.getNome(), " você não pode marcar jogo contra você mesmo!", "erro");
					}
					
				}
			}
			
			List<Usuario> adversario = usuarioDao.jogadores();
			model.addAttribute("adversario", adversario);
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/adversario");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		enviaMsg(modelAndView);
		return modelAndView; 
	}
	
	
	
	@RequestMapping(value = "/meusJogos", method = {RequestMethod.POST,RequestMethod.GET}) // Link do submit do form e o method POST que botou la
	public ModelAndView meusJogos(Model model, Boolean concordar, Resultado res, Integer placar_jogador1, Integer placar_jogador2) { // model é usado para mandar , e variavelNome está recebendo o name="nome" do submit feito na pagina principal 
		
		/*
		 * --- Excluir ---
		if(usuarioDao.findAll().size() < 2) {
			Usuario u = new Usuario();
			u.setAtivo(true);
			u.setPrimeiroAcesso(true);
			u.setTelefone("(11)98937-6271");
			u.setPerfil(perfilDao.buscarJogador().get(0));
			u.setLogin("juca123");
			u.setNome("Juca da Silva");
			u.setSenha("123");
			u.setAcesso("");
			usuarioDao.save(u);
			
			Classificacao c = new Classificacao();
			c.setAtivo(true);
			c.setJogador(u);
			classificacaoDao.save(c);
		}
		if(resultadoDao.findAll().size() == 0) {
			Resultado r = new Resultado();
			r.setJogador1(usuarioSessao);
			r.setJogador2(usuarioDao.findById(2).get());
			resultadoDao.save(r);
		}
		* --- Excluir --- 
		*/
		
		if(usuarioSessao != null) {
			if(concordar != null) {
				if(concordar == true) {
					Resultado resultado = resultadoDao.findById(res.getId()).get();
					if(!resultado.getConfirmado_jogador1() && !resultado.getConfirmado_jogador2() ) {
						resultado.setJogador1_placar(placar_jogador1);
						resultado.setJogador2_placar(placar_jogador2);
					}
					if(usuarioSessao.getId() == resultado.getJogador1().getId()) {
						resultado.setConfirmado_jogador1(true);
					}	
					if(usuarioSessao.getId() == resultado.getJogador2().getId()) {
						resultado.setConfirmado_jogador2(true);
					}	
					if(resultado.getConfirmado_jogador1() == true && resultado.getConfirmado_jogador2() == true) {
						//Calculando os pontos
						Classificacao minhaClassificacao = classificacaoDao.minhaClassificacao(usuarioSessao.getId());
						Classificacao adversario = new Classificacao();
						if(usuarioSessao.getId() != resultado.getJogador1().getId()) { /* Adversário = Jogador 1 */
							adversario = classificacaoDao.minhaClassificacao(resultado.getJogador1().getId());
							adversario.setGp(adversario.getGp()+resultado.getJogador1_placar());
							adversario.setGc(adversario.getGc()+resultado.getJogador2_placar());
							adversario.setSg(adversario.getGp() - adversario.getGc());
							
							minhaClassificacao.setGp(minhaClassificacao.getGp()+resultado.getJogador2_placar());
							minhaClassificacao.setGc(minhaClassificacao.getGc()+resultado.getJogador1_placar());
							minhaClassificacao.setSg(minhaClassificacao.getGp() - minhaClassificacao.getGc());
						} else {
							adversario = classificacaoDao.minhaClassificacao(resultado.getJogador2().getId()); /* Adversário = Jogador 2 */
							adversario.setGp(adversario.getGp()+resultado.getJogador2_placar());
							adversario.setGc(adversario.getGc()+resultado.getJogador1_placar());
							adversario.setSg(adversario.getGp() - adversario.getGc());
							
							minhaClassificacao.setGp(minhaClassificacao.getGp()+resultado.getJogador1_placar());
							minhaClassificacao.setGc(minhaClassificacao.getGc()+resultado.getJogador2_placar());
							minhaClassificacao.setSg(minhaClassificacao.getGp() - minhaClassificacao.getGc());
						}
						
						if(resultado.getJogador1_placar() > resultado.getJogador2_placar() ) { /*Jogador  Vencendo*/
							if(usuarioSessao.getId() == resultado.getJogador1().getId()) { /*Eu sou jogador 1*/
								minhaClassificacao.setJogos(minhaClassificacao.getJogos()+1);
								adversario.setJogos(adversario.getJogos()+1);
								minhaClassificacao.setPontos(minhaClassificacao.getPontos()+3);
								minhaClassificacao.setVitorias(minhaClassificacao.getVitorias()+1);
								adversario.setDerrotas(adversario.getDerrotas()+1);
							} else { /*Eu sou jogador 2*/
								minhaClassificacao.setJogos(minhaClassificacao.getJogos()+1); 
								adversario.setJogos(adversario.getJogos()+1);
								adversario.setPontos(adversario.getPontos()+3);
								adversario.setVitorias(adversario.getVitorias()+1);
								minhaClassificacao.setDerrotas(minhaClassificacao.getDerrotas()+1);
							}
						} else if(resultado.getJogador1_placar() < resultado.getJogador2_placar()) { /*Jogador  Perdendo*/
							if(usuarioSessao.getId() == resultado.getJogador1().getId()) { /*Eu sou jogador 1*/
								minhaClassificacao.setJogos(minhaClassificacao.getJogos()+1);
								adversario.setJogos(adversario.getJogos()+1);
								minhaClassificacao.setDerrotas(minhaClassificacao.getDerrotas()+1);
								adversario.setPontos(adversario.getPontos()+3);
								adversario.setVitorias(adversario.getVitorias()+1);
							} else { /*Empatando 2*/
								minhaClassificacao.setJogos(minhaClassificacao.getJogos()+1);
								adversario.setJogos(adversario.getJogos()+1);
								adversario.setDerrotas(adversario.getDerrotas()+1);
								minhaClassificacao.setPontos(minhaClassificacao.getPontos()+3);
								minhaClassificacao.setVitorias(minhaClassificacao.getVitorias()+1);
							}
						} else if(resultado.getJogador1_placar() == resultado.getJogador2_placar()) {
							minhaClassificacao.setJogos(minhaClassificacao.getJogos()+1);
							adversario.setJogos(adversario.getJogos()+1);
							adversario.setEmpates(adversario.getEmpates()+1);
							minhaClassificacao.setEmpates(minhaClassificacao.getEmpates()+1);
							minhaClassificacao.setPontos(minhaClassificacao.getPontos()+1);
							adversario.setPontos(adversario.getPontos()+1);
						}
						
						
						classificacaoDao.save(minhaClassificacao);
						resultado.setFinalizado(true);
					}
					resultadoDao.save(resultado);
				} else {
					Resultado resultado = resultadoDao.findById(res.getId()).get();
					if(usuarioSessao.getId() == resultado.getJogador1().getId()) {
						resultado.setConfirmado_jogador2(false);
						resultado.setConfirmado_jogador1(true);
					}
					if(usuarioSessao.getId() == resultado.getJogador2().getId()) {
						resultado.setConfirmado_jogador1(false);
						resultado.setConfirmado_jogador2(true);
					}
					resultado.setFinalizado(false);
					resultado.setJogador1_placar(placar_jogador1);
					resultado.setJogador2_placar(placar_jogador2);
					resultadoDao.save(resultado);
				}
				
			}
			
			
			List<Resultado> resultados = resultadoDao.meusJogos(usuarioSessao.getId());
			LocalDateTime now = LocalDateTime.now(); 
			model.addAttribute("now", now);
			model.addAttribute("meusJogos", resultados);
			model.addAttribute("usuarioSessao", usuarioSessao);
		}
		String link = verificaLink("pages/meusJogos");
		model.addAttribute("itemMenuSelecionado", itemMenuSelecionado);
		ModelAndView modelAndView = new ModelAndView(link);
		return modelAndView; 
	}

}
