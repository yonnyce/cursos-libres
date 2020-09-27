package co.edu.ucentral.app.servicio.common.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E, R extends PagingAndSortingRepository<E, Long>> implements CommonService<E> {

	@Autowired
	protected R repository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {

		return this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {

		return this.repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public E save(E entity) {
		return this.repository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

}
