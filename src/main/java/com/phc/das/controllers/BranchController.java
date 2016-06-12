package com.phc.das.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phc.das.dto.BranchDto;
import com.phc.das.entity.Branch;
import com.phc.das.services.BranchService;

@RestController
@RequestMapping("api/branches")
public class BranchController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BranchService branchService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BranchDto>> getBranches() {
        return new ResponseEntity<>(this.convertToDto(branchService.getAllBranch()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BranchDto> getBranch(@PathVariable Long id) throws Exception {
        Optional<Branch> branch = branchService.getById(id);
        if (!branch.isPresent()) {
            throw new Exception();
        }

        return new ResponseEntity<>(this.convertToDto(branch.get()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<BranchDto>> createBranch(@RequestBody BranchDto branchDto) {
        branchService.createBranch(this.convertToEntity(branchDto));
        return new ResponseEntity<>(this.convertToDto(branchService.getAllBranch()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<BranchDto>> updateBranch(@RequestBody BranchDto branchDto) {
        Branch branch = this.convertToEntity(branchDto);
        branchService.updateBranch(branch);
        return new ResponseEntity<>(this.convertToDto(branchService.getAllBranch()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @see https://github.com/jmnarloch/modelmapper-spring-boot-starter
     * @param branch
     * @return BranchDto
     */
    private BranchDto convertToDto(Branch branch) {
        BranchDto branchDto = modelMapper.map(branch, BranchDto.class);
        return branchDto;
    }

    private List<BranchDto> convertToDto(List<Branch> branches) {
        List<BranchDto> branchDtos = new ArrayList<>();
        for (Branch branch : branches) {
            branchDtos.add(this.convertToDto(branch));
        }
        return branchDtos;
    }

    private Branch convertToEntity(BranchDto branchDto) {
        Branch branch = modelMapper.map(branchDto, Branch.class);
        return branch;
    }
}

