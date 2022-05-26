package api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.dto.Hotel;

public interface IHotelDAO extends JpaRepository<Hotel, Integer> {

}
