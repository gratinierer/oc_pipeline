package functions;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;


import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Org {

    public static final String ORG_ROOT_CODE = "VW";
  public enum OrgType {root, group, bukrorg, ekorg, pool, user}

    @Value("${tquest.iface.benefit.purchazingOrgBackend}")
    private String validBenefitPurchazingOrg;

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @CsvBindByName(column = "Organization Id")
    private String orgId;

    @Column(nullable = false)
    @CsvBindByName(column = "Name")
    private String name;

    @Column(nullable = false)
    @CsvBindByName(column = "Website")
    private String webSite;

    @Column(nullable = false)
    @CsvBindByName(column = "Country")
    private String country;

    @Column(nullable = false)
    @CsvBindByName(column = "Description")
    private String description;

    @Column(nullable = false)
    @CsvBindByName(column = "Founded")
    private int founded;

    @Column(nullable = false)
    @CsvBindByName(column = "Industry")
    private String industry;

    @Column(nullable = false)
    @CsvBindByName(column = "Number of employees")
    private int employees;
    
    @Column(nullable = false)
    @CsvBindByName(column = "Job")
    private String job;

}
