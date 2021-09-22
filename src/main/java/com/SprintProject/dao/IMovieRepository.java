package com.SprintProject.dao;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Movie;

@Repository(value="IMovieRepository")
public interface IMovieRepository extends JpaRepository<Movie, Integer>   {
	List<Movie> findByTheater(int theaterid);
	@Query("select m from movie m join fetch m.show s where s.showStartTime=:pdate")
	List<Movie> findByDate(@Param("date")LocalDateTime date);

}
