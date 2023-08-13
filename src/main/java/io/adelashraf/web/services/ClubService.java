package io.adelashraf.web.services;

import io.adelashraf.web.dto.ClubDto;
import io.adelashraf.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    void saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void deleteClub(long clubId);

    List<ClubDto> searchClubs(String query);
}
