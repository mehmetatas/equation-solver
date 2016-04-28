package net.mehmetatas.controllers;

import net.mehmetatas.equation.EquationSolver;
import net.mehmetatas.equation.EquationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolverController {
    private final EquationSolver solver;

    @Autowired
    public SolverController(EquationSolver solver) {
        this.solver = solver;
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    public double[] solve(@RequestBody double[] system) {
        EquationSystem eqSystem = EquationSystem.create(system);
        return solver.solve(eqSystem);
    }
}
