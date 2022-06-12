package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Compra;
import pe.edu.upc.demo.repositories.ICompraRepository;
import pe.edu.upc.demo.serviceinterface.ICompraService;
import org.thymeleaf.exceptions.TemplateInputException;

@Service
public class CompraServiceImpl implements ICompraService{

	@Autowired
	private ICompraRepository cRepository;
	
	@Override
	public void insert(Compra compra) {
		cRepository.save(compra);
	}

	@Override
	public List<Compra> list() {
		return cRepository.findAll();
	}
}
