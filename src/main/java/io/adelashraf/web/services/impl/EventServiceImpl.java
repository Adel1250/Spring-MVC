package io.adelashraf.web.services.impl;

import io.adelashraf.web.dto.EventDto;
import io.adelashraf.web.mapper.EventMapper;
import io.adelashraf.web.models.Club;
import io.adelashraf.web.models.Event;
import io.adelashraf.web.repository.ClubRepository;
import io.adelashraf.web.repository.EventRepository;
import io.adelashraf.web.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static io.adelashraf.web.mapper.ClubMapper.mapToClub;
import static io.adelashraf.web.mapper.EventMapper.mapToEvent;
import static io.adelashraf.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        return mapToEventDto(eventRepository.findById(eventId).get());
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteClub(long eventId) {
        Event event = eventRepository.findById(eventId).get();
        eventRepository.delete(event);
    }
}
