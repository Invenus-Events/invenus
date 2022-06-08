package club.invenus.invenus.repository;

import org.springframework.data.repository.Repository;

import java.util.stream.Stream;

public interface ExtendedRepository<T, ID> extends Repository<T, ID> {

    Stream<T> streamAll();

}
