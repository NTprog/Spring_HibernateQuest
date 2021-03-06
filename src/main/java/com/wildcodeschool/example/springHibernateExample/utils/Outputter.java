package com.wildcodeschool.example.springHibernateExample.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.example.springHibernateExample.entities.User;
import com.wildcodeschool.example.springHibernateExample.repositories.UserDao;

@Component
public class Outputter implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private UserDao userDao;
	
    @Override
    public void run(String... args) throws Exception {
        
    	// Check combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + userDao.count());
    	 
         // Crée un nouvel utilisateur et l'enregistre dans la BDD
         User user1 = new User("Brenda", "Wildeuse", 19, "super sympas");
         LOG.info("******************");
         LOG.info(user1 + " has been created !");
         userDao.save(user1);
         LOG.info(user1 + " has been saved !");
         
         // Crée un second utilisateur et l'enregistre dans la BDD
         User user2 = new User("Brandon", "Wilder", 33, "extremement cool");
         LOG.info("******************");
         LOG.info(user2 + " has been created !");
         userDao.save(user2);
         LOG.info(user2 + " has been saved !");
         
         // Crée un second utilisateur et l'enregistre dans la BDD
         User user3 = new User("Jacky", "Wilde", 56, "extremement chaud");
         LOG.info("******************");
         LOG.info(user3 + " has been created !");
         userDao.save(user3);
         LOG.info(user3 + " has been saved !");

         // Lit les informations correspondant au second utilisateur
         User tempUser = userDao.findById(1L).get(); /* On écrit "2L" car le type de l'id est Long */  
         User tempUser2 = userDao.findById(2L).get();
         User tempUser3 =  userDao.findById(3L).get();
         
         LOG.info("******************");
         LOG.info("first user's firstName is " + tempUser.getFirstName());
         LOG.info("first user's lastName is " + tempUser.getLastName());
         LOG.info("first user's age is " + tempUser.getAge());
         LOG.info("******************");
         LOG.info("Second user's firstName is " + tempUser2.getFirstName());
         LOG.info("Second user's lastName is " + tempUser2.getLastName());
         LOG.info("Second user's age is " + tempUser2.getAge());
         LOG.info("******************");
         LOG.info("Third user's firstName is " + tempUser3.getFirstName());
         LOG.info("Third user's lastName is " + tempUser3.getLastName());
         LOG.info("Third user's age is " + tempUser3.getAge());

         // Liste les utilisateurs enregistrés dans la BDD
         LOG.info("******************");
         LOG.info("Users in list are ");
         for(User myUser : userDao.findAll()) {
             LOG.info(myUser.toString());
         };
         
         // UPDATE
         LOG.info("|******************|");
         LOG.info(user1.getFirstName() + " " + user1.getLastName() + " is not a man anymore");
         LOG.info("******************");
         tempUser2 = userDao.findById(2L).get();
         tempUser2.setFirstName("Micheline");
         tempUser2.setLastName("cactu");
         tempUser2.setAge(99);
         user1 = tempUser2;
         userDao.save(user1);
         LOG.info("******************");
         LOG.info("The character uodated from man to woman " + user1.getFirstName() + " " + user1.getLastName()
         + " of age " + user1.getAge());
         LOG.info("******************");

         // Supprime le second utilisateur de la BDD
         userDao.deleteById(2L); /* risque de provoquer une erreur si 
                                 tu n'as pas vidé ta table avant de relancer 
                                 ton application ! */

         /*     Liste les utilisateurs enregistrés dans la BDD
              (permet de vérifier que le second utilisateur
              a bien été supprimé de la BDD) */
         LOG.info("******************");
         LOG.info("Users in list are ");
         for(User myUser : userDao.findAll()) {
             LOG.info(myUser.toString());
         };
    }
}