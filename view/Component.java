package view;

import java.io.IOException;
import java.util.List;

public interface Component {

    void draw() throws IOException;


    interface Service<T> {

        T getById(int id);

        List<T> getAll();

        void save(T source);
    }
}
