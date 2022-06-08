package club.invenus.invenus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.stream.Stream;

@NoRepositoryBean
public interface ExtendedRepository<T, ID> extends CrudRepository<T, ID> {

    Stream<T> streamAllBy();

    default Stream<T> streamAll() {
        return streamAllBy();
    }

}
