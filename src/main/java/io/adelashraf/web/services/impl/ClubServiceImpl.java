package io.adelashraf.web.services.impl;

import io.adelashraf.web.dto.ClubDto;
import io.adelashraf.web.mapper.ClubMapper;
import io.adelashraf.web.models.Club;
import io.adelashraf.web.repository.ClubRepository;
import io.adelashraf.web.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static io.adelashraf.web.mapper.ClubMapper.mapToClub;
import static io.adelashraf.web.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        return clubRepository.findAll().stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public void saveClub(ClubDto clubDto) {
        clubRepository.save(mapToClub(clubDto));
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        clubRepository.delete(club);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());
    }
}
