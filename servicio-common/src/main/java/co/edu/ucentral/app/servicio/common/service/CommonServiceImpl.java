package co.edu.ucentral.app.servicio.common.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

public abstract class CommonServiceImpl<E extends EntidadBase, R extends PagingAndSortingRepository<E, Long>>
		implements CommonService<E> {

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
		this.verifyUniqueEntity(entity);
		return this.repository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public E update(E entity) {

		if (entity.getId() == null || !this.repository.findById(entity.getId()).isPresent()) {
			throw new EntityNotFoundException();
		}

		this.mapUpdateableFields(entity, this.repository.findById(entity.getId()).get());
		this.verifyUniqueEntity(entity);

		return this.repository.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	protected abstract void verifyUniqueEntity(E entity);

	protected abstract E mapUpdateableFields(E newVersionEntity, E oldVersionEntity);

}
