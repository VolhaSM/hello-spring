package by.it.academy.Repository;

import by.it.academy.pojo.Recipeint;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

@Repository
public class UserRepository implements ApplicationContextAware, UserDao<Recipeint> {

    private ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory; //заинджектить

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Recipeint find(String userId) {


        return sessionFactory
                .getCurrentSession()
                .createQuery("from Recipeint r where r.userId=:userId", Recipeint.class)
                .setParameter("userId", userId)
                .list()
                .stream()
                .findFirst()
                .orElse(null);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipeint> findAll(String searchStr) {
        return sessionFactory.
                getCurrentSession()
                .createQuery("from Recipeint r where r.emailAdress like :searchStr", Recipeint.class)
                .setParameter("searchStr", "%" + searchStr + "%")
                .list();
    }

    @Override
    @Transactional
    public void create(Recipeint recipeint) {
        sessionFactory.getCurrentSession().
                saveOrUpdate(recipeint);

    }


    @Override
    public void update(Recipeint recipeint) {

        sessionFactory.getCurrentSession()
                .update(recipeint);

    }

    @Override
    @Transactional(readOnly = true)
    public Recipeint read(Class clazz, Serializable id) {


        return (Recipeint) sessionFactory.getCurrentSession()
                .get(clazz, id);
    }

    @Override
    public void delete(Recipeint recipeint) {

    }
}
