package club.invenus.invenus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Stream;

@NoRepositoryBean
public interface ExtendedRepository<T, ID> extends CrudRepository<T, ID> {

    Stream<T> streamAllBy();

    default Stream<T> streamAll() {
        return streamAllBy();
    }

    @NotNull
    <S extends T> List<S> saveAll(@NotNull Iterable<S> entities);

}
