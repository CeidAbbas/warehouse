package ir.hinceid.warehouse.repository.body.warehouse;

import ir.hinceid.warehouse.model.warhouse.PackageWarehouseInventory;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IPackageWarehouseInventoryRepository;
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
public class PackageWarehouseInventoryRepository {
    /*@Override
    public List<PackageWarehouseInventory> findAll() {
        return null;
    }

    @Override
    public List<PackageWarehouseInventory> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PackageWarehouseInventory> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PackageWarehouseInventory> findAllById(Iterable<UUID> uuids) {
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
    public void delete(PackageWarehouseInventory entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends PackageWarehouseInventory> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PackageWarehouseInventory> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PackageWarehouseInventory> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PackageWarehouseInventory> findById(UUID uuid) {
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
    public <S extends PackageWarehouseInventory> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PackageWarehouseInventory> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PackageWarehouseInventory> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PackageWarehouseInventory getOne(UUID uuid) {
        return null;
    }

    @Override
    public PackageWarehouseInventory getById(UUID uuid) {
        return null;
    }

    @Override
    public PackageWarehouseInventory getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends PackageWarehouseInventory> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PackageWarehouseInventory> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PackageWarehouseInventory> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PackageWarehouseInventory> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PackageWarehouseInventory> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PackageWarehouseInventory> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PackageWarehouseInventory, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }*/
}
