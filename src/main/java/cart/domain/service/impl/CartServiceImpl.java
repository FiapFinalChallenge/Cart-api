package cart.domain.service.impl;

import cart.application.dto.response.CartResponse;
import cart.application.mapper.CartMapper;
import cart.domain.repository.ICartRepository;
import cart.domain.service.contract.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final ICartRepository repository;
    private final CartMapper mapper;

    @Override
    public List<CartResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::of)
                .toList();
    }
}
