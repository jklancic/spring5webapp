package xyz.blackmoster.spring5webapp.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import xyz.blackmoster.spring5webapp.model.WorkExperience;

public interface WorkExperienceRepository extends CrudRepository<WorkExperience, UUID> {
}
