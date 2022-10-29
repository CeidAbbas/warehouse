package ir.hinceid.warehouse.repository.body.warehouse;

import ir.hinceid.warehouse.model.warhouse.Forwarding;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IForwardingRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
public class ForwardingRepository implements IForwardingRepository {
    @Override
    public List<Forwarding> findAll() {
        return null;
    }

    @Override
    public List<Forwarding> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Forwarding> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Forwarding> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Forwarding entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Forwarding> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Forwarding> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Forwarding> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Forwarding> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Forwarding> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Forwarding> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Forwarding> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Forwarding getOne(UUID uuid) {
        return null;
    }

    @Override
    public Forwarding getById(UUID uuid) {
        return null;
    }

    @Override
    public Forwarding getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Forwarding> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Forwarding> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Forwarding> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Forwarding> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Forwarding> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Forwarding> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Forwarding, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
