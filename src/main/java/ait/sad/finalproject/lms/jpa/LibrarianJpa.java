package ait.sad.finalproject.lms.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import ait.sad.finalproject.lms.model.Book;
import ait.sad.finalproject.lms.model.Librarian;
import ait.sad.finalproject.lms.model.Student;

@Service
public class LibrarianJpa implements JpaRepository<Librarian, Integer>
{
	@Autowired JdbcTemplate template;
	ResultSet rs;
	
	public Librarian validate(HttpServletRequest req, Librarian details) 
	{
		String sql = "select * from librarian where username='" + details.getUsername() + "' and password='" + details.getPassword() + "'";
		List<Librarian> librarian = template.query(sql, new LibrarianMapper());
		return librarian.size() > 0 ? librarian.get(0) : null;
	}
	
	@Override
	public Page<Librarian> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Librarian> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Librarian> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Librarian entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Librarian> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Librarian> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Librarian> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Librarian> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Librarian> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Librarian> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Librarian> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Librarian> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Librarian> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Librarian> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Librarian> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Librarian getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Librarian> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Librarian> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public void issueBook(Student student, Book book) 
	{
		String sql = "insert into user_book values (?,?)";
		String sql1 = "update book set copies_available = copies_available - 1 where bid = ?";
		template.update(sql, new Object[] {book.getBid(), student.getUid()});
		template.update(sql1, new Object[] {book.getBid()});
		String message = "Hi, " + student.getUid() + " you have borrowed an available copy of a book titled "+ book.getTitle() +". "
				+ "We inform you to return or renew within 15 days to avoid any fines. Thankyou. Regards, Librarian";
		try
		{
			sendEmail(student.getUid(),book.getTitle(),message);
			System.out.println("Email Sent successfully");
		}
		catch(MailException ex)
		{
			ex.printStackTrace();
		}
	}

	private void sendEmail(int uid, String title, String message) 
	{
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setTo("harsha.bonala.1@gmail.com");
		System.out.println("st"+uid+"@ait.asia");
		emailMessage.setText(message);
		emailMessage.setSubject("Issued a book titled "+ title);
		emailMessage.setFrom("st121327@ait.asia");
	}

	public void returnBook(Student student, Book book) 
	{
		String sql = "delete from user_book where bid = ? and uid = ?";
		String sql1 = "update book set copies_available = copies_available + 1 where bid = ?";
		template.update(sql, new Object[] {book.getBid(), student.getUid()});
		template.update(sql1, new Object[] {book.getBid()});
		String message = "Hi, " + student.getUid() + " you have returned a borrowed copy of a book titled "+ book.getTitle() +". "
				+ "We will inform you later regarding any fines or you can contact librarian. Thankyou. Regards, Librarian";
		try
		{
			sendEmail(student.getUid(),book.getTitle(),message);
			System.out.println("Email Sent successfully");
		}
		catch(MailException ex)
		{
			ex.printStackTrace();
		}
	}

	public void register(Student student) 
	{
		String sql = "insert into student values (?,?,?,?,?,?)";
		template.update(sql, new Object[] {student.getUid(), student.getEmail(), student.getName(), student.getPassword(),"student", student.getUsername()});
	}

	public void unregister(Student student) 
	{
		String sql = "delete from student where uid = ? and name = ?";
		template.update(sql, new Object[] {student.getUid(), student.getName()});
	}
}

class LibrarianMapper implements RowMapper<Librarian>
{
	public Librarian mapRow(ResultSet rs, int arg1) throws SQLException
	{
		Librarian librarian = new Librarian();
		librarian.setUsername(rs.getString("username"));
		librarian.setPassword(rs.getString("password"));
		return librarian;
	}
}
