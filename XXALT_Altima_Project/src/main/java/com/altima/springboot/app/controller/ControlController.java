package com.altima.springboot.app.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.altima.springboot.app.models.entity.ControlHora;
import com.altima.springboot.app.models.entity.ControlProduccionMuestra;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.ProduccionDetallePedido;
import com.altima.springboot.app.models.entity.ProduccionPedido;
import com.altima.springboot.app.models.service.IControlProduccionMuestraService;
import com.altima.springboot.app.models.service.IDisenioPrendaService;
import com.altima.springboot.app.models.service.IProduccionDetalleService;
import com.altima.springboot.app.models.service.IProduccionPedidoService;

@CrossOrigin(origins = { "*" })
@Controller
public class ControlController {
	@Autowired
	private  IControlProduccionMuestraService DCPM;
	
	@Autowired
	private  IProduccionDetalleService Orden;
	
	@Autowired
	private IDisenioPrendaService Prenda;
	
	@Autowired
	private IProduccionPedidoService Pedido;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	@GetMapping("/control-de-produccion")
	//@RequestMapping(value = "/control-de-produccion", method = RequestMethod.GET)
	//@ResponseBody
	public String listControlProduccion(Model model) {		
		
	
		model.addAttribute("pedidos", DCPM.ListarPedidos());
		return "control-de-produccion";
	}
	
	@RequestMapping(value = "/listar-procesos/{id}/{tipo}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_trazos(@PathVariable(value="id") Long id , @PathVariable(value="tipo") String tipo) {	
		return  DCPM.Operaciones(id,tipo);
	}
	
	@RequestMapping(value = "/operadores", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> operadores() {		
		return  DCPM.Operadores();
	}
	
	@RequestMapping(value = "/orden-pedidos/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> OrdenesTrazo(@PathVariable(value="id") Long id) {		
		
		return Orden.ListarMuestrasTrazo(id);
	}
	
	@RequestMapping(value = "/terminados/{id}/{tipo}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> trazo_terminados(@PathVariable(value="id") Long id , @PathVariable(value="tipo") Long tipo) {		
		return  Orden.Terminados(id, tipo);
	}
	
	@RequestMapping(value = "/listar-horas/{id}/{tipo}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object []> listar_horas(@PathVariable(value="id") Long id,  @PathVariable(value="tipo") String tipo) {		
		
		return  DCPM.ContadorHoras(id,tipo);	
	}
	
	@PostMapping("/guardar-proceso")
	public String guardacatalogo(String operador,String f1 ,String f2,String id,String tipo ,HttpServletRequest request) throws ParseException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(tipo);
		if ( tipo.equals("trazo")) {
			System.out.println("Los id son :"+id);
			
			if ( (id != null) && (!id.equals("")) ){
				String [] array = id.split(",");
				for(int i= 0 ; i<array.length;i++) {
				
					System.out.println(""+array[i]);
					
					System.out.println("Soy un trazo");
					ControlProduccionMuestra muestra = new ControlProduccionMuestra();
					Integer contador = DCPM.Contador("1");
					muestra.setIdText("TRAZO"+(100+contador+1));
					muestra.setIdPedido(Long.parseLong(array[i]));
					muestra.setFechaRecepcion(f1+":00");
					muestra.setFechaEntrega(f2+":00");
					muestra.setIdOperario(operador);
					muestra.setTipo("1");
					muestra.setCreadoPor(auth.getName());
					muestra.setActualizadoPor("Null");
					muestra.setFechaCreacion(hourdateFormat.format(date));
					muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
					muestra.setEstatusTiempo("Nuevo");
					DCPM.save(muestra);

				}
			}
			
			
		}
		
		if ( tipo.equals("corte")) {
			System.out.println("Los id son :"+id);
			if ( (id != null) && (!id.equals("")) ){
				String [] array = id.split(",");
				for(int i= 0 ; i<array.length;i++) {
				
					System.out.println(""+array[i]);
					ControlProduccionMuestra muestra = new ControlProduccionMuestra();
					Integer contador = DCPM.Contador("2");
					muestra.setIdText("TRAZO"+(100+contador+1));
					muestra.setIdPedido(Long.parseLong(array[i]));
					muestra.setFechaRecepcion(f1+":00");
					muestra.setFechaEntrega(f2+":00");
					muestra.setIdOperario(operador);
					muestra.setTipo("2");
					muestra.setCreadoPor(auth.getName());
					muestra.setActualizadoPor("Null");
					muestra.setFechaCreacion(hourdateFormat.format(date));
					muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
					muestra.setEstatusTiempo("Nuevo");
					DCPM.save(muestra);

				}
			}
			System.out.println("Soy un corte");
		}
		
		if ( tipo.equals("confeccion")) {
			System.out.println("Los id son :"+id);
			if ( (id != null) && (!id.equals("")) ){
				String [] array = id.split(",");
				for(int i= 0 ; i<array.length;i++) {
				
					System.out.println(""+array[i]);
					
					System.out.println("Soy un trazo");
					ControlProduccionMuestra muestra = new ControlProduccionMuestra();
					Integer contador = DCPM.Contador("3");
					muestra.setIdText("TRAZO"+(100+contador+1));
					muestra.setIdPedido(Long.parseLong(array[i]));
					muestra.setFechaRecepcion(f1+":00");
					muestra.setFechaEntrega(f2+":00");
					muestra.setIdOperario(operador);
					muestra.setTipo("3");
					muestra.setCreadoPor(auth.getName());
					muestra.setActualizadoPor("Null");
					muestra.setFechaCreacion(hourdateFormat.format(date));
					muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
					muestra.setEstatusTiempo("Nuevo");
					DCPM.save(muestra);

				}
			}
			
			System.out.println("Soy una confeccion");
		}
		
		if ( tipo.equals("planchado")) {
			
			
System.out.println("Los id son :"+id);
			
			if ( (id != null) && (!id.equals("")) ){
				String [] array = id.split(",");
				for(int i= 0 ; i<array.length;i++) {
				
					System.out.println(""+array[i]);
					
					System.out.println("Soy un trazo");
					ControlProduccionMuestra muestra = new ControlProduccionMuestra();
					Integer contador = DCPM.Contador("4");
					muestra.setIdText("TRAZO"+(100+contador+1));
					muestra.setIdPedido(Long.parseLong(array[i]));
					muestra.setFechaRecepcion(f1+":00");
					muestra.setFechaEntrega(f2+":00");
					muestra.setIdOperario(operador);
					muestra.setTipo("4");
					muestra.setCreadoPor(auth.getName());
					muestra.setActualizadoPor("Null");
					muestra.setFechaCreacion(hourdateFormat.format(date));
					muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
					muestra.setEstatusTiempo("Nuevo");
					DCPM.save(muestra);

				}
			}
			
			
			System.out.println("Soy un planchado");
		}
		
		if ( tipo.equals("terminado")) {
			
			
System.out.println("Los id son :"+id);
			
			if ( (id != null) && (!id.equals("")) ){
				String [] array = id.split(",");
				for(int i= 0 ; i<array.length;i++) {
				
					System.out.println(""+array[i]);
					
					System.out.println("Soy un trazo");
					ControlProduccionMuestra muestra = new ControlProduccionMuestra();
					Integer contador = DCPM.Contador("5");
					muestra.setIdText("TRAZO"+(100+contador+1));
					muestra.setIdPedido(Long.parseLong(array[i]));
					muestra.setFechaRecepcion(f1+":00");
					muestra.setFechaEntrega(f2+":00");
					muestra.setIdOperario(operador);
					muestra.setTipo("5");
					muestra.setCreadoPor(auth.getName());
					muestra.setActualizadoPor("Null");
					muestra.setFechaCreacion(hourdateFormat.format(date));
					muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
					muestra.setEstatusTiempo("Nuevo");
					DCPM.save(muestra);

				}
			}
			
			
			System.out.println("Soy un terminado");
		}
		
		return "redirect:control-de-produccion";

	}
	
	@PostMapping("/play")
	public String playProceso(Long idproceso ,String tipo  ,HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ControlProduccionMuestra muestra;
		muestra=DCPM.findOne(idproceso);
		muestra.setEstatusTiempo("Play");
		muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
		muestra.setActualizadoPor(auth.getName());
		DCPM.save(muestra);
		if ( tipo.equals("trazo")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("1");
			hora.setCreadoPor(auth.getName());
			hora.setFechaCreacion(hourdateFormat.format(date));
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("corte")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("2");
			hora.setCreadoPor(auth.getName());
			hora.setFechaCreacion(hourdateFormat.format(date));
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("confeccion")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("3");
			hora.setCreadoPor(auth.getName());
			hora.setFechaCreacion(hourdateFormat.format(date));
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("planchado")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("4");
			hora.setCreadoPor(auth.getName());
			hora.setFechaCreacion(hourdateFormat.format(date));
			DCPM.saveHora(hora);
		}
		
		if ( tipo.equals("terminado")) {
			System.out.println("Soy un trazo");
			ControlHora hora = new ControlHora();
			hora.setIdControlProduccionMuestra(muestra.getIdControlProduccionMuestra());
			hora.setFechaInicio(hourdateFormat.format(date));
			hora.setEstatus("Play");
			hora.setTipo("5");
			hora.setCreadoPor(auth.getName());
			hora.setFechaCreacion(hourdateFormat.format(date));
			DCPM.saveHora(hora);
		}
		
		return "redirect:control-de-produccion";

	}
	
	@PostMapping("/pausa")
	public String pausoProceso(Long idproceso,String tipo  , HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		ControlProduccionMuestra muestra;
		muestra=DCPM.findOne(idproceso);
		muestra.setEstatusTiempo("Pausa");
		muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
		muestra.setActualizadoPor(auth.getName());
		DCPM.save(muestra);
		
		ControlHora hora ;
		Integer id= DCPM.Pausa(muestra.getIdControlProduccionMuestra());
		hora=DCPM.findOneHora(Long.valueOf(id));
		hora.setFechaFin(hourdateFormat.format(date));
		hora.setEstatus("Pausa");
		hora.setUltimaFechaModificacion(hourdateFormat.format(date));
		hora.setActualizadoPor(auth.getName());
		DCPM.saveHora(hora);
		return "redirect:control-de-produccion";

	}
	
	@PostMapping("/stop")
	public String stopProceso(Long idproceso ,String tipo , HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println("Hola soy stop");
		ControlProduccionMuestra muestra;
		muestra=DCPM.findOne(idproceso);
		muestra.setEstatusTiempo("Stop");
		muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
		muestra.setActualizadoPor(auth.getName());
		DCPM.save(muestra);
		
		ControlHora hora ;
		Integer id= DCPM.Pausa(muestra.getIdControlProduccionMuestra());
		hora=DCPM.findOneHora(Long.valueOf(id));
		hora.setFechaFin(hourdateFormat.format(date));
		hora.setEstatus("Stop");
		hora.setUltimaFechaModificacion(hourdateFormat.format(date));
		hora.setActualizadoPor(auth.getName());
		DCPM.saveHora(hora);
		return "redirect:control-de-produccion";

	}

	@GetMapping("/agregar-control-muestra")
	public String agregarMuestra(Model model) {
		model.addAttribute("listPrendas", DCPM.findAllPrenda());
		return "agregar-control-muestra";
	}

	@PostMapping("/guardar-prenda-foranea")
	public String guardar_prenda_foranea(String familia,String nombre ,String precio,
			String cantidad,String talla,String largo,String idPedido,HttpServletRequest request) {
		
		
		System.out.println("La id pedido es "+idPedido);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		DisenioPrenda prenda = new DisenioPrenda();
		prenda.setIdFamiliaPrenda(Long.valueOf(familia));
		prenda.setNombrePrenda(nombre);
		prenda.setPrecio(precio);
		prenda.setTipoLargo(largo);
		prenda.setDescripcionPrenda(talla);
		prenda.setIdMarcador("1");
		prenda.setEstatus(Long.valueOf(1));
		prenda.setPrendaLocal("1");
		prenda.setCreadoPor(auth.getName());
		prenda.setFechaCreacion(hourdateFormat.format(date));
		Prenda.save(prenda);
		prenda.setIdText("PrendaForanea"+(prenda.getIdPrenda()+100));
		Prenda.save(prenda);
		
		if (idPedido.equals("0")) {
			ProduccionPedido pedido = new ProduccionPedido();
			pedido.setIdCliente(Long.valueOf(1));
			pedido.setEstatus("1");
			pedido.setCantidad(cantidad);
			pedido.setDescripcion("Probando...");
			pedido.setCreadoPor(auth.getName());
			pedido.setFechaCreacion(hourdateFormat.format(date));
			pedido.setActualizadoPor(auth.getName());
			pedido.setUltimaFechaModificacion(hourdateFormat.format(date));
			pedido.setIdText("Pedido");
			Pedido.save(pedido);
			pedido.setIdText("PEDIDO"+(pedido.getIdPedido()+100));
			Pedido.save(pedido);
			idPedido=Long.toString(pedido.getIdPedido());
		}
		
		else {
			ProduccionPedido pedido =Pedido.findOne(Long.valueOf(idPedido));
			pedido.setCantidad(Integer.toString( ( Integer.parseInt(pedido.getCantidad())+Integer.parseInt(cantidad))));
			Pedido.save(pedido);
		}
		ProduccionDetallePedido orden = new ProduccionDetallePedido();
		orden.setIdPedido(Long.valueOf(idPedido));
		orden.setIdTela(Long.valueOf(1));
		orden.setTalla(talla);
		orden.setLargo(largo);
		orden.setDescripcion("probando ando...");
		orden.setIdText("ORDEN");
		orden.setCreadoPor(auth.getName());
		orden.setActualizadoPor(auth.getName());
		orden.setUltimaFechaModificacion(hourdateFormat.format(date));
		orden.setUltimaFechaModificacion(hourdateFormat.format(date));
		orden.setIdInventario(null);
		orden.setEstatus_confeccion("Corrrecto");
		orden.setEstatus("1");
		orden.setIdPrenda(prenda.getIdPrenda());
		orden.setIdFamiliaGenero(Long.valueOf(familia));
		orden.setCosto(precio);
		orden.setCantidad(cantidad);
		Orden.save(orden);
		
		
		// LISTAR
		
		
	
		return "redirect:aux/"+idPedido;
		 
	}
	
	@RequestMapping(value = "/aux/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String aux (@PathVariable(value="id") String id ) {		
		return  id;
	}
	

	
	@PostMapping("/PausarTodo")
	public String PausarTodo(Long id , String tipo ,  HttpServletRequest request) {	
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<Object []> aux = DCPM.PausarMuestras(id, tipo);
		@SuppressWarnings("rawtypes")
		Iterator iterador = aux.listIterator(); 
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		while( iterador.hasNext() ) {
			ControlProduccionMuestra muestra;
			muestra=DCPM.findOne(Long.valueOf(iterador.next().toString()));
			
			muestra.setEstatusTiempo("Pausa");
			muestra.setUltimaFechaModificacion(hourdateFormat.format(date));
			muestra.setActualizadoPor(auth.getName());
			DCPM.save(muestra);
			
			
			ControlHora hora ;
			Integer id2= DCPM.Pausa(muestra.getIdControlProduccionMuestra());
			hora=DCPM.findOneHora(Long.valueOf(id2));
			hora.setFechaFin(hourdateFormat.format(date));
			hora.setEstatus("Pausa");
			hora.setUltimaFechaModificacion(hourdateFormat.format(date));
			hora.setActualizadoPor(auth.getName());
			DCPM.saveHora(hora);
		}
	
		return "redirect:control-de-produccion";
	}

}
