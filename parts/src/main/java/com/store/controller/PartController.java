package com.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.PartModel;
import com.store.repository.PartRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PartController {
    
    @Autowired
    PartRepository partRepository;

    @GetMapping("/parts")
    public ResponseEntity<List<PartModel>> getAllParts(@RequestParam(required = false) String partName) {
        try {
            List<PartModel> parts = new ArrayList<PartModel>();

            if (partName == null)
                partRepository.findAll().forEach(parts::add);
            else
                partRepository.findByPartName(partName).forEach(parts::add);

            if (parts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(parts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<PartModel> getPartById(@PathVariable("id") long id) {
        Optional<PartModel> partData = partRepository.findById(id);

        if (partData.isPresent()) {
            return new ResponseEntity<>(partData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/parts")
    public ResponseEntity<PartModel> createPart(@RequestBody PartModel part) {
        try {
            PartModel _part = partRepository
                    .save(new PartModel(part.getPartName(), part.getPartNumber(), part.getPartDescription(), part.getPartPrice()));
            return new ResponseEntity<>(_part, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/parts/{id}")
    public ResponseEntity<PartModel> updatePart(@PathVariable("id") long id, @RequestBody PartModel part) {
        Optional<PartModel> partData = partRepository.findById(id);

        if (partData.isPresent()) {
            PartModel _part = partData.get();
            _part.setPartName(part.getPartName());
            _part.setPartNumber(part.getPartNumber());
            _part.setPartDescription(part.getPartDescription());
            _part.setPartPrice(part.getPartPrice());
            return new ResponseEntity<>(partRepository.save(_part), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/parts/{id}")
    public ResponseEntity<HttpStatus> deletePart(@PathVariable("id") long id) {
        try {
            partRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/parts")
    public ResponseEntity<HttpStatus> deleteAllParts() {
        try {
            partRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/parts/name")
    public ResponseEntity<List<PartModel>> findByPartName(@RequestParam String partName) {
        try {
            List<PartModel> parts = partRepository.findByPartName(partName);

            if (parts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(parts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parts/number")
    public ResponseEntity<List<PartModel>> findByPartNumber(@RequestParam String partNumber) {
        try {
            List<PartModel> parts = partRepository.findByPartNumber(partNumber);

            if (parts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(parts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parts/description")
    public ResponseEntity<List<PartModel>> findByPartDescription(@RequestParam String partDescription) {
        try {
            List<PartModel> parts = partRepository.findByPartDescription(partDescription);

            if (parts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(parts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parts/price")
    public ResponseEntity<List<PartModel>> findByPartPrice(@RequestParam double partPrice) {
        try {
            List<PartModel> parts = partRepository.findByPartPrice(partPrice);

            if (parts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(parts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
