package repository;

import entity.CitiesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class CitiesRepo implements AbstractRepo<CitiesEntity, Integer, String>{

    @Override
    public void create(CitiesEntity entity) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public CitiesEntity findById(Integer id) {

        try {
            EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
            TypedQuery<CitiesEntity> typedQuery = em.createNamedQuery("Cities.findById", CitiesEntity.class).setParameter("id", id);

            return typedQuery.getSingleResult();
        }
        catch( NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CitiesEntity findByName(String name) {

        try {
            EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
            TypedQuery<CitiesEntity> typedQuery = em.createNamedQuery("Cities.findByName", CitiesEntity.class).setParameter("name", name);

            return typedQuery.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
