scope({c0_Enum:5, c0_Security:5});
defaultScope(1);
intRange(-8, 7);
stringLength(18);

c0_Enum = Abstract("c0_Enum");
c0_Security = Abstract("c0_Security");
c0_NoSecurity = Clafer("c0_NoSecurity").withCard(1, 1);
c0_Broken = Clafer("c0_Broken").withCard(1, 1);
c0_Weak = Clafer("c0_Weak").withCard(1, 1);
c0_Medium = Clafer("c0_Medium").withCard(1, 1);
c0_Strong = Clafer("c0_Strong").withCard(1, 1);
c0_Task = Abstract("c0_Task");
c0_name = c0_Task.addChild("c0_name").withCard(1, 1);
c0_SecurityTestTask = Clafer("c0_SecurityTestTask").withCard(1, 1);
c0_security = c0_SecurityTestTask.addChild("c0_security").withCard(1, 1);
c0_Security.extending(c0_Enum).refToUnique(Int);
c0_NoSecurity.extending(c0_Security);
Constraint(implies(some(global(c0_NoSecurity)), equal(joinRef(global(c0_NoSecurity)), constant(0))));
c0_Broken.extending(c0_Security);
Constraint(implies(some(global(c0_Broken)), equal(joinRef(global(c0_Broken)), constant(1))));
c0_Weak.extending(c0_Security);
Constraint(implies(some(global(c0_Weak)), equal(joinRef(global(c0_Weak)), constant(2))));
c0_Medium.extending(c0_Security);
Constraint(implies(some(global(c0_Medium)), equal(joinRef(global(c0_Medium)), constant(3))));
c0_Strong.extending(c0_Security);
Constraint(implies(some(global(c0_Strong)), equal(joinRef(global(c0_Strong)), constant(4))));
c0_name.refToUnique(string);
c0_SecurityTestTask.extending(c0_Task);
c0_SecurityTestTask.addConstraint(equal(joinRef(join($this(), c0_name)), constant("\"SecurityTestTask\"")));
c0_security.refToUnique(c0_Security);