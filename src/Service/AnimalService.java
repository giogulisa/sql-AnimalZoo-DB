package Service;

import controller.MainController;
import dao.DBUtil;
import model.Animal;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class AnimalService {
    private static final Logger log = Logger.getLogger(MainController.class);
    public static void addAnimal(Animal animal) {
        DBUtil dbUtil = DBUtil.getInstance();
        Session session = dbUtil.getSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        log.info("ბაზაში დაემატა" + animal);
        //System.out.println("წარმატებით შევინახეთ : "+ animal);
        dbUtil.closeConnection();
    }
}
