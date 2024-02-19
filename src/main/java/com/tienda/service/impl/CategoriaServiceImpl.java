package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional
    public List<Categoria> getCategoria(boolean activos) {
        List<Categoria> lista = categoriaDao.findAll();
        if (activos) {
            //remover los elementos inactivos
            lista.removeIf(c -> !c.isActivo());
            
        }
        return lista;
    }

}
