package org.example.service;

import org.example.dto.BookDetailDto;
import org.example.entity.BookDetail;
import org.example.exception.DataNotFoundException;
import org.example.mapper.BookDetailMapper;
import org.example.repository.BookDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {

    @Autowired
    private BookDetailRepository repository;

    @Override
    public void create(BookDetailDto bookDetailDto) {
        BookDetail bookDetail = BookDetailMapper.INSTANCE.toEntity(bookDetailDto);
        bookDetail.getWorkSpace().setAvailable(false);
        repository.save(bookDetail);

    }

    @Override
    public BookDetailDto readById(Long id) throws DataNotFoundException {
        return repository.findById(id).map(BookDetailMapper.INSTANCE::toDto).orElseThrow(() ->
                new DataNotFoundException("Data not found by id" + id));
    }


    @Override
    public void update(BookDetailDto bookDetailDto) {
        BookDetail bookDetail = BookDetailMapper.INSTANCE.toEntity(bookDetailDto);
        if (repository.existsById(bookDetail.getId())) {
            repository.save(bookDetail);
        }

    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }

    }
}
