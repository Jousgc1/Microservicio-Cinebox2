package Cinebox.com.Servicie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cinebox.com.Modelo.Combo;
import Cinebox.com.Repository.ComboRepository;


@Service
public class ComboService {
	
	@Autowired
	private final ComboRepository comboRepository;
	
	
	
	
	public ComboService(ComboRepository comboRepository) {
		this.comboRepository=comboRepository;
		
	}
	
	
	public List<Combo>FindAllCombo(){
		return comboRepository.findAll();
	}
	
	
	public Optional<Combo> findComboById(Long id) {
        return comboRepository.findById(id);
    }
	

	 public Combo saveCombo(Combo combo) {
	        return comboRepository.save(combo);
	    }

	    public void deleteCombo(Long id) {
	        comboRepository.deleteById(id);
	    }
	
	
}
