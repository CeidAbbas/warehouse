package ir.hinceid.warehouse.repository.body.warehouse;

import ir.hinceid.warehouse.model.warhouse.Package;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IPackageRepository;
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
public class PackageRepository implements IPackageRepository {


    @Override
    public List<Package> findAll() {
        return null;
    }

    @Override
    public List<Package> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Package> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Package> findAllById(Iterable<UUID> uuids) {
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
    public void delete(Package entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Package> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Package> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Package> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Package> findById(UUID uuid) {
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
    public <S extends Package> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Package> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Package> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Package getOne(UUID uuid) {
        return null;
    }

    @Override
    public Package getById(UUID uuid) {
        return null;
    }

    @Override
    public Package getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Package> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Package> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Package> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Package> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Package> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Package> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Package, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
