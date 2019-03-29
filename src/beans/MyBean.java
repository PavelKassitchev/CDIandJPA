package beans;

import entities.Weber;
import entities.WeberEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class MyBean implements Serializable {

    private EntityManagerFactory emf;
    private EntityManager em;

    private WeberEntity weberEntity;

    public WeberEntity getWeberEntity() {
        return weberEntity;
    }

    public void setWeberEntity(WeberEntity weberEntity) {
        this.weberEntity = weberEntity;
    }

    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public MyBean() {
        map = new HashMap<>();
        map.put("1","one");
        map.put("2", "two");
        weberEntity = new WeberEntity();
        weberEntity.setName("Paul");
        weberEntity.setAnswers(map.get("1"));
        weberEntity.setNumber(1);
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = emf.createEntityManager();
    }

    public String process() {
        String result = "";

        weberEntity.setAnswers(map.get("1"));
        result = weberEntity.getAnswers();

        em.persist(weberEntity);

        return result;
    }

    public static void main(String[] args) {
        Weber weber = new Weber();
        weber.setNumber(2);
        weber.setName("John");
        weber.setAnswers("ahahaha");

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(weber);
        transaction.commit();
    }
}
