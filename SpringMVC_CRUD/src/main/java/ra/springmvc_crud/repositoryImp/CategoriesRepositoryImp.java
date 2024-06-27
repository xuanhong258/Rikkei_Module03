package ra.springmvc_crud.repositoryImp;

import org.springframework.stereotype.Repository;
import ra.springmvc_crud.model.Categories;
import ra.springmvc_crud.repository.CategoriesRepository;
import ra.springmvc_crud.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoriesRepositoryImp implements CategoriesRepository {
    @Override
    public List<Categories> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Categories> categoriesList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_categories()}");

            ResultSet rs = callSt.executeQuery();
            categoriesList = new ArrayList<>();
            while (rs.next()){
                Categories catalog = new Categories();
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));

                categoriesList.add(catalog);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return categoriesList;
    }

    @Override
    public boolean createCatalog(Categories catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_categories(?,?,?)}");
            callSt.setString(1, catalog.getCatalogName());
            callSt.setString(2, catalog.getDescription());
            callSt.setBoolean(3,catalog.isStatus());

            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public Categories findById(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Categories catalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_catalog_by_id(?)}");

            callSt.setInt(1, catalogId);
            ResultSet rs = callSt.executeQuery();
            catalog = new Categories();
            if (rs.next()){
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return catalog;
    }

    @Override
    public boolean update(Categories catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_categories(?,?,?,?)}");
            callSt.setInt(1, catalog.getCatalogId());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getDescription());
            callSt.setBoolean(4,catalog.isStatus());

            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_categories(?)}");
            callSt.setInt(1,catalogId);
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
}
