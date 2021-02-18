package ait.sad.finalproject.lms.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ait.sad.finalproject.lms.model.Book;

@Service
public interface BookJpa extends JpaRepository<Book, Integer>
{

	@Override
	@Query(value = "select * from book order by bid asc", nativeQuery = true)
	public Page<Book> findAll(Pageable pageable);

	@Override
	public <S extends Book> S save(S entity);

	//@Override
	//public Optional<Book> findById(Integer id);

	@Override
	public boolean existsById(Integer id);

	@Override
	public long count();

	//@Override
	//public void deleteById(Integer bid);

	@Override
	public void delete(Book entity);

	@Override
	public void deleteAll(Iterable<? extends Book> entities);

	@Override
	public void deleteAll();

	@Override
	public <S extends Book> Optional<S> findOne(Example<S> example);

	@Override
	public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable);

	@Override
	public <S extends Book> long count(Example<S> example);

	@Override
	public <S extends Book> boolean exists(Example<S> example);

	@Override
	public List<Book> findAll();

	@Override
	public List<Book> findAll(Sort sort);

	@Override
	public List<Book> findAllById(Iterable<Integer> ids);

	@Override
	public <S extends Book> List<S> saveAll(Iterable<S> entities);

	@Override
	public void flush();

	@Override
	public <S extends Book> S saveAndFlush(S entity);

	

	@Override
	public <S extends Book> List<S> findAll(Example<S> example);

	@Override
	public <S extends Book> List<S> findAll(Example<S> example, Sort sort);
	
	@Query(value = "SELECT uid,name,username,title,author1,author2,author3,edition from student, book, user_book "
			+ "where book.id = user_book.bid and user_book.bid = bid and user_book.uid = student.id and "
			+ "student.username = :username", nativeQuery = true)
	public List<Book> findBooksByUsers(String username);
	
	@Query(value = "SELECT * from student, book, user_book "
			+ "where book.id = user_book.bid and user_book.bid = bid "
			+ "and user_book.uid = student.id ", nativeQuery = true)
	public List<Book> findAllBorrowed();
	
	@Query(value = "select bid,title,author1,author2,author3,edition,copies_available from book order by bid", nativeQuery = true)
	public List<Book> findAllbooks();
}
