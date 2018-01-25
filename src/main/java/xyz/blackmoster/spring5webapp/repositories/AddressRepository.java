package xyz.blackmoster.spring5webapp.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import xyz.blackmoster.spring5webapp.models.Address;

public interface AddressRepository extends CrudRepository<Address, UUID> {
}
