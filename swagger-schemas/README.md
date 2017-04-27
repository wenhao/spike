## 结构

类型划分：

1. info.yaml
2. paths.yaml
3. definitions.yaml
4. responses.yaml
5. parameters.yaml
6. main.yaml

功能层次划分：

1. base.yaml
2. common.yaml
3. XXX-paths.yaml
4. XXX-definitions.yaml

info.yaml
paths
  feature-name
    XXX.yaml
    XXX-{id}.yaml
definitions
  common
    XXX.yaml
  feature-name
    XXX.yaml
parameters
responses    
