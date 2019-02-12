/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginWeb.Domain.Interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabricio Ramos
 * @param <T>
 */
public interface IRepository<T> { 
    public List<T> GetALL(String filtro)throws SQLException;;
    public T GetById(String id)throws SQLException;;
    public void Add(T obj)throws SQLException;;
    public void Update(T obj)throws SQLException;;
    public void Remove(T obj)throws SQLException;;
}
