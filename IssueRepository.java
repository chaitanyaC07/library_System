package library.entities;

import org.springframework.data.jpa.repository.JpaRepository;

//public interface UserRepository extends JpaRepository< Book, Integer> {
	public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
