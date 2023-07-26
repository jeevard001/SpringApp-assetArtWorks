package net.jeeva.assetArtworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jeeva.assetArtworks.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}